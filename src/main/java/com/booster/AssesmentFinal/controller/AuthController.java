package com.booster.AssesmentFinal.controller;


import com.booster.AssesmentFinal.data.Usuario;
import com.booster.AssesmentFinal.service.AuthenticationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AuthController {

    @Autowired
    private AuthenticationService authenticationService;

    @PostMapping("/auth/login")
    public ResponseEntity<?> authenticate(@RequestBody Usuario usuarioReq){
        try {
            String token = authenticationService.getTokenUsuario(usuarioReq);
            return new ResponseEntity<>(token, HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>(e.getCause().toString(), HttpStatus.BAD_REQUEST);
        }

    }

}
