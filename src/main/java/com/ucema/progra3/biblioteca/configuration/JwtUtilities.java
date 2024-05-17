package com.ucema.progra3.biblioteca.configuration;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jws;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.Date;

@Component
public class JwtUtilities {

    private final String secret = "2b44b0b00fd822d8ce753e54dac3dc4e06c2725f7db930f3b9924468b53194dbccdbe23d7baa5ef5fbc414ca4b2e64700bad60c5a7c45eaba56880985582fba4";
    private final Long expiration = 3600l;

    public String generateToken(String username, Long id, String rol) {
        return Jwts.builder()
                .setSubject(username) // Establece el subject
                .claim("id", id) //Establece las Claims: información del usuario en el token.
                .setIssuedAt(new Date(System.currentTimeMillis())) //Fecha de emisión del token.
                .setExpiration(Date.from(Instant.now().plus(expiration, ChronoUnit.SECONDS))) //Fecha de expiracion del token.
                .signWith(SignatureAlgorithm.HS256, secret) //Firma el token.
                .compact(); //Crea una cadena JWT con la configuración establecida.
    }

    public String getToken(HttpServletRequest httpServletRequest) {
        String barrerToken = httpServletRequest.getHeader("Authorization"); //Obtiene el contenido del Authorization Header
        if(StringUtils.hasText(barrerToken) && barrerToken.startsWith("Bearer ")) { // Verifica que sea un token JWT
            return barrerToken.substring(7, barrerToken.length()); //Obtiene la cadena del token.
        }
        return null;
    }

    public boolean validateToken(String token) {
        try {
            // Si puedo obtener las claims entonces el token es valido
            Jws<Claims> claimsJws =  Jwts.parser().setSigningKey(secret).parseClaimsJws(token);
            if(isTokenExpired(token)) { return false; } // Verfica que no haya expirado.
            return true;
        } catch (Exception e) {
            // Si el token no es valido, puedo realizar alguna acción
        }
        return false;
    }

    public Claims extractAllClaims(String token) {
        return Jwts.parser().setSigningKey(secret).parseClaimsJws(token).getBody();
    }

    public String extractUsername(String token) {
        return extractAllClaims(token).getSubject();
    }

    public Long extractId(String token) {
        return Long.parseLong((String) extractAllClaims(token).get("id"));
    }

    public Date extractExpiration(String token) {
        return extractAllClaims(token).getExpiration();
    }

    public Boolean isTokenExpired(String token) {
        return extractExpiration(token).before(new Date());
    }
}
