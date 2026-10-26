package aula.microservicos.aluno.restful;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;

import javax.crypto.SecretKey;

import org.springframework.stereotype.Service;

import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.Date;
import java.util.Map;

@Service
public class JwtUtil {

    private final SecretKey key;

    public JwtUtil() {
        this.key = Jwts.SIG.HS256.key().build();
    }

    public String gerarToken(
            String username,
            Map<String, Object> claimsExtras) {

        Instant agora = Instant.now();

        return Jwts.builder()
                .subject(username)
                .claims(claimsExtras)
                .issuedAt(Date.from(agora))
                .expiration(Date.from(
                        agora.plus(1, ChronoUnit.HOURS)))
                .signWith(key, Jwts.SIG.HS256)
                .compact();
    }

    public Claims obterClaims(String token) {
        return Jwts.parser()
                .verifyWith(key)
                .build()
                .parseSignedClaims(token)
                .getPayload();
    }

    public boolean validarToken(String token) {
        try {
            obterClaims(token);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}
