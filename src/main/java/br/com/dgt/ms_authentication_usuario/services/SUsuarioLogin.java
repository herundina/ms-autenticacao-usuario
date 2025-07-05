package br.com.dgt.ms_authentication_usuario.services;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import br.com.dgt.ms_authentication_usuario.repository.RUsuario;
import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class SUsuarioLogin implements UserDetailsService{

    private final RUsuario repository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return this.repository.findByEmailIgnoreCase(username).orElseThrow();
    }

}