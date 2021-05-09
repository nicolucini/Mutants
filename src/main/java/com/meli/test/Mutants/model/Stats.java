package com.meli.test.Mutants.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.math.BigDecimal;

public class Stats {
    @JsonProperty("count_mutant_dna")
    private Long countMutantDNA;
    @JsonProperty("count_human_dna")
    private Long countHumanDNA;
    @JsonProperty("ratio")
    private BigDecimal ratio;

    public Stats(Long countMutantDNA, Long countHumanDNA) {
        this.countMutantDNA = countMutantDNA;
        this.countHumanDNA = countHumanDNA;
        this.ratio = countHumanDNA != 0L ? BigDecimal.valueOf(countMutantDNA / countHumanDNA) : BigDecimal.ZERO;
    }

    public Long getCountMutantDNA() {
        return countMutantDNA;
    }

    public void setCountMutantDNA(Long countMutantDNA) {
        this.countMutantDNA = countMutantDNA;
    }

    public Long getCountHumanDNA() {
        return countHumanDNA;
    }

    public void setCountHumanDNA(Long countHumanDNA) {
        this.countHumanDNA = countHumanDNA;
    }

    public BigDecimal getRatio() {
        return ratio;
    }
}
