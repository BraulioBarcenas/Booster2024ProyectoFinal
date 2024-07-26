package com.booster.AssesmentFinal.repository;

import com.booster.AssesmentFinal.data.Libro;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface LibroRepository extends MongoRepository<Libro,String> {

}
