package com.meli.test.Mutants.repository;

import com.meli.test.Mutants.model.DNA;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface MutantRepository extends MongoRepository<DNA, String> {
}
