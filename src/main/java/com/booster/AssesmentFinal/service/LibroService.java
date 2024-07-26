package com.booster.AssesmentFinal.service;

import com.booster.AssesmentFinal.data.Libro;
import com.booster.AssesmentFinal.repository.LibroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LibroService {

    @Autowired
    private LibroRepository libroRepository;

    public Libro guardarLibro(Libro libro) {
        return libroRepository.save(libro);
    }

    public List<Libro> obtenerLibros(){
        return libroRepository.findAll();
    }

    public void eliminarLibro(String id){
        libroRepository.deleteById(id);
    }


}
