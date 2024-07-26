package com.booster.AssesmentFinal.controller;

import com.booster.AssesmentFinal.data.Libro;
import com.booster.AssesmentFinal.service.LibroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/libros")
public class LibroController {

    @Autowired
    private LibroService libroService;

    @PostMapping()
    public ResponseEntity<?> guardarLibro(@RequestBody Libro libro){
        try{
            Libro nuevo_libro = libroService.guardarLibro(libro);
            return new ResponseEntity<>(nuevo_libro, HttpStatus.CREATED);
        }catch (DuplicateKeyException e){
            return new ResponseEntity<>("libro ya existe", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping()
    public ResponseEntity<?> actualizarLibro(@RequestBody Libro libro){
        try{
            Libro nuevo_libro = libroService.guardarLibro(libro);
            return new ResponseEntity<>(nuevo_libro, HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>(e.getCause().toString(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


    @GetMapping()
    public ResponseEntity<?> obtenerLibros(){
        try{
            List<Libro> libros = libroService.obtenerLibros();
            return new ResponseEntity<>(libros, HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>(e.getCause().toString(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping
    public ResponseEntity<?> eliminarLibro(@RequestParam String id){
        try{
            libroService.eliminarLibro(id);
            return new ResponseEntity<>("Libro eliminado", HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>(e.getCause().toString(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


}
