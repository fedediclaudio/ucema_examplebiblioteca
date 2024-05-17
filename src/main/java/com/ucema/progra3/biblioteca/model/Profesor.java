package com.ucema.progra3.biblioteca.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Entity
public class Profesor extends Usuario {

    @Column(name = "fecha_ingreso")
    private LocalDate fechaIngreso;

    public Profesor(String username, String password, String nombreCompleto, String identificacion, String dni, String email, LocalDate fechaNacimiento, LocalDate fechaIngreso) {
        super(username, password, nombreCompleto, identificacion, dni, email, fechaNacimiento);
        this.fechaIngreso = fechaIngreso;
    }

    public Profesor() {

    }

    @Override
    public LocalDate calcularFechaDevolucion(LocalDate date) {
        return date.plusDays(90);
    }

    public LocalDate getFechaIngreso() {
        return fechaIngreso;
    }

    public void setFechaIngreso(LocalDate fechaIngreso) {
        this.fechaIngreso = fechaIngreso;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        List<GrantedAuthority> authorities = new ArrayList<>();
        authorities.add(new SimpleGrantedAuthority("PROFESOR"));
        return authorities;
    }
}
