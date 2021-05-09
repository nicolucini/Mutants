package com.meli.test.Mutants.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import java.util.Objects;

@Document(collection="dna")
public class DNA {
    private boolean mutant;
    @Id
    private String sequence;

    public DNA() {
    }

    public boolean isMutant() {
        return mutant;
    }

    public void setMutant(boolean mutant) {
        this.mutant = mutant;
    }

    public String getSequence() {
        return sequence;
    }

    public void setSequence(String sequence) {
        this.sequence = sequence;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DNA dna = (DNA) o;
        return mutant == dna.mutant && Objects.equals(sequence, dna.sequence);
    }

    @Override
    public int hashCode() {
        return Objects.hash(mutant, sequence);
    }
}
