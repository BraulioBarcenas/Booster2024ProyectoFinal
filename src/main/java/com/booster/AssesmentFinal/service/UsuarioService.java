package com.booster.AssesmentFinal.service;


import com.booster.AssesmentFinal.data.Usuario;
import com.booster.AssesmentFinal.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public List<Usuario> obtenerUsuarios(){
        return usuarioRepository.findAll();
    }

    public Usuario guardarUsuario(Usuario usuario){
        String plainPassword = usuario.getPassword();
        usuario.setPassword(passwordEncoder.encode(plainPassword));
        return usuarioRepository.save(usuario);
    }

    public void eliminarUsuario(String id){
        usuarioRepository.deleteById(id);
    }
}
