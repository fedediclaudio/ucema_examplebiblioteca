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
public class Alumno extends Usuario{

    @Column()
    private String carrera;

    @Column()
    private String anio;

    public Alumno(String username, String password, String nombreCompleto, String identificacion, String dni, String email, LocalDate fechaNacimiento, String carrera, String anio) {
        super(username, password, nombreCompleto, identificacion, dni, email, fechaNacimiento);
        this.carrera = carrera;
        this.anio = anio;
    }

    public Alumno() {

    }


    @Override
    public LocalDate calcularFechaDevolucion(LocalDate date) {
        return null;
    }

    public String getCarrera() {
        return carrera;
    }

    public void setCarrera(String carrera) {
        this.carrera = carrera;
    }

    public String getAnio() {
        return anio;
    }

    public void setAnio(String anio) {
        this.anio = anio;
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
        authorities.add(new SimpleGrantedAuthority("ALUMNO"));
        return authorities;
    }

    @Override
    public String getRole() {
        return "ALUMNO";
    }
}
