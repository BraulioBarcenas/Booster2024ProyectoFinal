package com.booster.AssesmentFinal.service;

import com.booster.AssesmentFinal.data.Usuario;
import com.booster.AssesmentFinal.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthenticationService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private JwtService jwtService;

    public String getTokenUsuario(Usuario usuarioReq){

        Usuario usuario = usuarioRepository.findByEmail(usuarioReq.getEmail()).orElse(null);
        if (usuario != null) {
            boolean passwordMatches = passwordEncoder.matches(usuarioReq.getPassword(),usuario.getPassword());
            if (passwordMatches){
                return jwtService.generateToken(usuarioReq.getEmail());
            }
        }

        return null;
    }
}
