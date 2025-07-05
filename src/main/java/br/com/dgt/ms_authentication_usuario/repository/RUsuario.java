package br.com.dgt.ms_authentication_usuario.repository;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import br.com.dgt.ms_authentication_usuario.entity.EUsuario;

@Repository
public interface RUsuario extends JpaRepository<EUsuario, Long> {
    
    Optional<EUsuario> findByEmailIgnoreCase(String email);
}