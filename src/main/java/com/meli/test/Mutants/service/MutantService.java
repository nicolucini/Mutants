package com.meli.test.Mutants.service;


import com.meli.test.Mutants.model.DNA;
import com.meli.test.Mutants.model.Sequence;
import com.meli.test.Mutants.repository.MutantRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.Optional;

@Service
public class MutantService {

    @Autowired
    private MutantRepository mutantRepository;

    private static final Logger log = LoggerFactory.getLogger(MutantService.class);

    private static final Integer AMOUNT_TO_DETERMINATE_MUTANT = 2;

    public boolean resolveMutant(Sequence sequence) {
        boolean isMutant = getResult(sequence);
        saveResult(sequence, isMutant);
        return isMutant;
    }

    private boolean getResult(Sequence sequence) {

        log.info("Inicio del servicio getResult");
        if(log.isDebugEnabled()) {
            log.debug("Buscando resultado de dna " + sequence.toString());
        }
        String[] dna = sequence.getDna();
        int count = 0;
        for(int i = 0; i < dna.length && count < AMOUNT_TO_DETERMINATE_MUTANT; i++) {
            for(int j = 0; j < dna.length-3; j++) {
                char originNode = dna[i].charAt(j);

                if(j + 3 < dna.length) {
                    char intermediateNode1 = findNode(dna, i, j+1);
                    char intermediateNode2 = findNode(dna, i, j+2);
                    char finishNode = findNode(dna, i, j+3);

                    if(originNode == finishNode && originNode == intermediateNode1 && originNode == intermediateNode2) {
                        count++;
                    }
                }
                if(i + 3 < dna.length) {
                    char intermediateNode1 = findNode(dna, i+1, j);
                    char intermediateNode2 = findNode(dna, i+2, j);
                    char finishNode = findNode(dna, i+3, j);

                    if(originNode == finishNode && originNode == intermediateNode1 && originNode == intermediateNode2) {
                        count++;
                    }

                }
                if(j + 3 < dna.length && i + 3 < dna.length) {
                    char intermediateNode1 = findNode(dna, i+1, j+1);
                    char intermediateNode2 = findNode(dna, i+2, j+2);
                    char finishNode = findNode(dna, i+3, j+3);

                    if(originNode == finishNode && originNode == intermediateNode1 && originNode == intermediateNode2) {
                        count++;
                    }

                }
                if(j - 3 > 0 && i + 3 < dna.length) {
                    char intermediateNode1 = findNode(dna, i+1, j-1);
                    char intermediateNode2 = findNode(dna, i+2, j-2);
                    char finishNode = findNode(dna, i+3, j-3);

                    if(originNode == finishNode && originNode == intermediateNode1 && originNode == intermediateNode2) {
                        count++;
                    }
                }
            }
        }
        boolean isMutant = count >= AMOUNT_TO_DETERMINATE_MUTANT;
        saveResult(sequence, isMutant);
        log.info("Fin del servicio getResult");
        if(log.isDebugEnabled()) {
            log.debug("Resultado de prueba de dna: Es mutante = " + isMutant);
        }
        return isMutant;
    }

    private void saveResult(Sequence sequence, boolean isMutant) {
        if(log.isDebugEnabled()) {
            log.debug("Se va a intentar guardar la secuencia: " + sequence);
        }
        String sequenceString = Arrays.toString(sequence.getDna());
        DNA newSequence = new DNA();
        newSequence.setSequence(sequenceString);
        newSequence.setMutant(isMutant);
        Optional<DNA> optional = this.mutantRepository.findById(sequenceString);
        if(log.isDebugEnabled()) {
            log.debug("La secuencia: " + sequence + (optional.isPresent() ? " ya" : " no") + " existe en la base de datos");
        }
        if(!optional.isPresent()) {
            log.info("Se guarda la secuencia ya que no existia");
            this.mutantRepository.save(newSequence);
            log.info("Se guardo exitosamente la secuencia");
        }
    }

    private char findNode(String[] dna, int i, int j) {
        return dna[i].charAt(j);
    }
}
