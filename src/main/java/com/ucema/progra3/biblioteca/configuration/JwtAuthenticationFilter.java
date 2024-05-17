package com.ucema.progra3.biblioteca.configuration;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jws;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;
import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.Date;

@Component
public class JwtAuthenticationFilter extends OncePerRequestFilter {

    @Autowired
    private JwtUtilities jwtUtilities;

    @Autowired
    private UserDetailsService userDetailsService;


    @Override
    protected void doFilterInternal(HttpServletRequest request,
                                    HttpServletResponse response,
                                    FilterChain filterChain) throws ServletException, IOException {
        // Obtiene el Token JWT de la request
        String token = jwtUtilities.getToken(request);
        if(token != null && jwtUtilities.validateToken(token)) { //Si existe ese token y es valido
            String username = jwtUtilities.extractUsername(token); //Obtengo el username del token
            UserDetails user = userDetailsService.loadUserByUsername(username); //Obtengo el objeto
            if(user != null) { //Si ese usuario existe
                // Creo una representación de la informacion de autenticacion con el username y el listado de credenciales
                UsernamePasswordAuthenticationToken authentication =
                        new UsernamePasswordAuthenticationToken(user.getUsername(), null, user.getAuthorities());
                // Agrego el usuario al contexto de seguridad actual. Nos va a permitir recuperarlo durante toda la request.
                SecurityContextHolder.getContext().setAuthentication(authentication);
            }

        }
        // Invoca el siguiente filtro de la cadena.
        filterChain.doFilter(request, response);
    }
}
