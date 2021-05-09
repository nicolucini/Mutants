package com.meli.test.Mutants.controller;


import com.meli.test.Mutants.model.Sequence;
import com.meli.test.Mutants.service.MutantService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/mutant")
public class MutantController {
    private static final Logger log = LoggerFactory.getLogger(MutantController.class);

    @Autowired
    private MutantService mutantService;

    @PostMapping("/")
    public ResponseEntity<Void> isMutantDNA(@RequestBody Sequence sequence) {
        log.info("Inicio de metodo isMutantDNA");
        if(log.isDebugEnabled()) {
            log.debug("Buscando resultado de dna " + sequence.toString());
        }
        return mutantService.resolveMutant(sequence) ? ResponseEntity.ok().build() : ResponseEntity.status(HttpStatus.FORBIDDEN).build();

    }
}
