package com.booster.AssesmentFinal.repository;

import com.booster.AssesmentFinal.data.Usuario;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface UsuarioRepository extends MongoRepository<Usuario,String> {

    Optional<Usuario> findByEmail(String email);
}