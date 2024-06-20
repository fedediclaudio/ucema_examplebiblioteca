package com.ucema.progra3.biblioteca.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

import java.util.Arrays;


@Configuration
@EnableWebSecurity
public class SpringSecurityConfig {

    @Autowired
    private UserDetailsService userDetailsService;

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                //.cors(Customizer.withDefaults()) // Habilitar CORS (Cross-Origin Resource Sharing) con la configuración por defecto
                .csrf(AbstractHttpConfigurer::disable) // Deshabilitar la protección CSRF (Cross-Site Request Forgery), ya que no estamos usando sesiones en el front
                .authorizeHttpRequests((authorize) -> authorize
                        .requestMatchers("api/login").permitAll() // Permitir a todos los usuarios iniciar sesión
                        .requestMatchers(HttpMethod.GET, "api/usuario").permitAll() // Permitir a todos los usuarios crear alumnos
                        .requestMatchers("api/libro/**").permitAll() // Permitir a todos los usuarios hacer consultas sobre los libros
                        .anyRequest().authenticated() // Cualquier otra solicitud debe ser autenticada
                )
                .httpBasic(Customizer.withDefaults()) // Usar autenticación HTTP básica
                .sessionManagement((sessionManagement) -> sessionManagement
                        .sessionCreationPolicy(SessionCreationPolicy.STATELESS) // Establecer la creación de sesiones en STATELESS, la aplicación no crea sesiones de usuario
                );
        return http.build();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

}
