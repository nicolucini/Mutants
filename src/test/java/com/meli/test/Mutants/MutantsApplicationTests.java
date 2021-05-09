package com.meli.test.Mutants;

import com.meli.test.Mutants.model.Sequence;
import com.meli.test.Mutants.service.MutantService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.web.context.WebApplicationContext;

@SpringBootTest
class MutantsApplicationTests {
	@Autowired
	private WebApplicationContext appContext;

	@Test
	void contextLoads() {
	}

	@Test
	public void givenMutantDNAShouldBeTrue() throws Exception {
		//GIVEN
		String[] dna = {"ATGCGA","CAGTGC","TTATGT","AGAAGG","CCCCTA","TCACTG"};
		Sequence sequence = new Sequence(dna);
		MutantService mutantService = new MutantService();
		//WHEN
		Boolean isMutant = mutantService.resolveMutant(sequence);
		//THEN
		Assertions.assertTrue(isMutant);

	}

	@Test
	public void givenHumanDNAShouldBeFalse() throws Exception {
		//GIVEN
		String[] dna = {"TTGCTA","CAGTGC","TTATGT","AGAAGG","TCCCTA","TCACTG"};
		Sequence sequence = new Sequence(dna);
		MutantService mutantService = new MutantService();
		//WHEN
		Boolean isMutant = mutantService.resolveMutant(sequence);
		//THEN
		Assertions.assertFalse(isMutant);

	}

}
