package br.com.dgt.ms_authentication_usuario.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/home")
public class CHome {
    
//tetese
    @GetMapping
    public ResponseEntity<String> homePage(){
        return ResponseEntity.ok("HomePage de teste!");
    }
}
