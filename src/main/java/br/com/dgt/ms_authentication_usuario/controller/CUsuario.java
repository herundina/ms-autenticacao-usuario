package br.com.dgt.ms_authentication_usuario.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.dgt.ms_authentication_usuario.dto.DLogin;
import br.com.dgt.ms_authentication_usuario.entity.EUsuario;
import br.com.dgt.ms_authentication_usuario.services.token.GeraToken;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
@RestController
@RequestMapping("/")
public class CUsuario {
    
    private final AuthenticationManager manager;
    private final GeraToken service;

    @PostMapping
    public ResponseEntity<String> login(@Valid @RequestBody DLogin login){

        var token = new UsernamePasswordAuthenticationToken(login.email(), login.senha());
        var userDetails = this.manager.authenticate(token);
        String tokenJwt = this.service.gerarToken( (EUsuario) userDetails.getPrincipal());
        return ResponseEntity.ok(tokenJwt);
    }   
}