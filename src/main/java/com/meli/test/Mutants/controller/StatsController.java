package com.meli.test.Mutants.controller;

import com.meli.test.Mutants.model.Stats;
import com.meli.test.Mutants.service.StatsService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/stats")
public class StatsController {
    private static final Logger log = LoggerFactory.getLogger(StatsController.class);

    @Autowired
    private StatsService statsService;

    @GetMapping("/")
    public Stats stats() {
        log.info("Inicio de metodo stats");
        Stats stats = statsService.getStats();
        if(log.isDebugEnabled()) {
            log.debug("resultado estadisticas: Ratio = " + stats.getRatio() + " Humanos: " + stats.getCountHumanDNA() + " Mutantes: " + stats.getCountMutantDNA());
        }
        return stats;

    }
}
