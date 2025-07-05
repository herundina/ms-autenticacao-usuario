package br.com.dgt.ms_authentication_usuario.services.token;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneOffset;
import org.springframework.stereotype.Service;
import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTCreationException;
import br.com.dgt.ms_authentication_usuario.entity.EUsuario;

@Service
public class GeraToken {

    public String gerarToken(EUsuario usuario){

        try {
            Algorithm algorithm = Algorithm.HMAC256("8747s64fs65f46464654634426542#$2#$@#$@#$@65465462");
            
            return  JWT.create()
                .withIssuer("Saude/Zoopet")
                .withSubject(usuario.getEmail())
                .withSubject(usuario.getSenha())
                .withExpiresAt(this.expiracao(30))
                .sign(algorithm);
                        
        } catch (JWTCreationException exception){
            throw new RuntimeException("Não foi possível autenticar o usuário;");
        }
    }

    private Instant expiracao(Integer minutos) {
        return LocalDateTime.now()
            .plusMinutes(minutos).toInstant(ZoneOffset.of("-03:00"));
}
}