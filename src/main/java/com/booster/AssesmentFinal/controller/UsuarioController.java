package com.booster.AssesmentFinal.controller;


import com.booster.AssesmentFinal.data.Usuario;
import com.booster.AssesmentFinal.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;

    @GetMapping()
    public ResponseEntity<?> ObtenerTodosLosUsuarios(){
        try{
            List<Usuario> usuarios = usuarioService.obtenerUsuarios();
            return new ResponseEntity<>(usuarios, HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>(e.getCause().toString(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping()
    public ResponseEntity<?> guardarUsuario(@RequestBody Usuario usuario){
        try{
            Usuario nuevo_usuario = usuarioService.guardarUsuario(usuario);
            return new ResponseEntity<>(nuevo_usuario, HttpStatus.CREATED);
        }catch (Exception e){
            return new ResponseEntity<>("Ocurrió un error: "+ e.getCause().toString(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping()
    public ResponseEntity<?> actualizarUsuario(@RequestBody Usuario usuario){
        try{
            Usuario nuevo_usuario = usuarioService.guardarUsuario(usuario);
            return new ResponseEntity<>(nuevo_usuario, HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>(e.getCause().toString(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping
    public ResponseEntity<?> eliminarUsuario(@RequestParam String id){
        try{
            usuarioService.eliminarUsuario(id);
            return new ResponseEntity<>("Usuario eliminado", HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>(e.getCause().toString(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


}
