package com.ucema.progra3.biblioteca.model;

import jakarta.persistence.Entity;

import java.time.LocalDate;

@Entity
public class Profesor extends Usuario {

    private LocalDate fechaIngreso;

    public Profesor(String nombreCompleto, String identificacion, String dni, String email, LocalDate fechaNacimiento, LocalDate fechaIngreso) {
        super(nombreCompleto, identificacion, dni, email, fechaNacimiento);
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
}
