package com.meli.test.Mutants.model;

import java.util.Arrays;

public class Sequence {
    private String[] dna;

    public Sequence() {
    }

    public Sequence(String[] dna) {
        this.dna = dna;
    }

    public String[] getDna() {
        return dna;
    }

    public void setDna(String[] dna) {
        this.dna = dna;
    }

    @Override
    public String toString() {
        return "MutantRequest{" +
                "dna=" + Arrays.toString(dna) +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Sequence sequence = (Sequence) o;
        return Arrays.toString(this.dna).equals(Arrays.toString(sequence.dna));
    }

    @Override
    public int hashCode() {
        return Arrays.hashCode(dna);
    }
}
