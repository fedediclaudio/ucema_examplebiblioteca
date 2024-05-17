package com.ucema.progra3.biblioteca.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;


@Configuration
@EnableWebSecurity
public class SpringSecurityConfig {

    @Autowired
    private JwtAuthenticationFilter jwtAuthenticationFilter;

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .csrf((csrf) -> csrf.disable()) // Deshabilitar la protección CSRF (Cross-Site Request Forgery), ya que no estamos usando sesiones en el front
                .authorizeHttpRequests((authorize) -> authorize
                        .requestMatchers(HttpMethod.POST, "/api/auth/**").permitAll() // Permitir a todos los usuarios loguearse
                        .requestMatchers(HttpMethod.GET, "api/libro/**").permitAll() // Permitir a todos los usuarios hacer consultas sobre los libros
                        .requestMatchers("api/libro/**").authenticated() // Solo los usuarios autenticados pueden hacer cambios en los libros
                        .requestMatchers("api/prestamo/**").hasAuthority("PROFESOR") // Solo los profesores pueden acceder los préstamos
                        .anyRequest().authenticated() // Cualquier otra solicitud debe ser autenticada
                )
                .httpBasic(Customizer.withDefaults()) // Usar autenticación HTTP básica
                .sessionManagement((sessionManagement) -> sessionManagement
                        .sessionCreationPolicy(SessionCreationPolicy.STATELESS) // Establecer la creación de sesiones en STATELESS, la aplicación no crea sesiones de usuario
                );
        // Agregamos un filtro personalizado
        http.addFilterBefore(jwtAuthenticationFilter, UsernamePasswordAuthenticationFilter.class);
        return http.build();
    }

    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration authenticationConfiguration) throws Exception {
        return authenticationConfiguration.getAuthenticationManager();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

}
