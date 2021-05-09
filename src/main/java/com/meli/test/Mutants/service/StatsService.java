package com.meli.test.Mutants.service;


import com.meli.test.Mutants.model.DNA;
import com.meli.test.Mutants.model.Stats;
import com.meli.test.Mutants.repository.MutantRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StatsService {
    private static final Logger log = LoggerFactory.getLogger(StatsService.class);

    @Autowired
    private MutantRepository mutantRepository;

    public Stats getStats() {

        log.info("Inicio del servicio getStats");
        List<DNA> dnas = mutantRepository.findAll();
        log.info("cantidad de resultados: " + dnas.size());
        Long countMutants = dnas.stream().filter( dna -> dna.isMutant()).count();
        Long countHumans = dnas.size() - countMutants;
        Stats stats = new Stats(countMutants,countHumans);

        if(log.isDebugEnabled()) {
            log.debug("resultado estadisticas: Ratio = " + stats.getRatio() + " Humanos: " + stats.getCountHumanDNA() + " Mutantes: " + stats.getCountMutantDNA());
        }
        log.info("Fin del servicio getStats");
        return stats;
    }
}
