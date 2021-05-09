package com.meli.test.Mutants.repository;

public class ResultStats {
    private boolean mutant;
    private Long amount;

    public ResultStats(boolean mutant, Long amount) {
        this.mutant = mutant;
        this.amount = amount;
    }

    public boolean isMutant() {
        return mutant;
    }

    public void setMutant(boolean mutant) {
        this.mutant = mutant;
    }

    public Long getAmount() {
        return amount;
    }

    public void setAmount(Long amount) {
        this.amount = amount;
    }
}
