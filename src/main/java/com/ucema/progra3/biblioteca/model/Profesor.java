package com.ucema.progra3.biblioteca.model;

import java.time.LocalDate;

public class Profesor extends Usuario {

    private LocalDate fechaIngreso;

    public Profesor(String nombreCompleto, String identificacion, String dni, String email, LocalDate fechaNacimiento, LocalDate fechaIngreso) {
        super(nombreCompleto, identificacion, dni, email, fechaNacimiento);
        this.fechaIngreso = fechaIngreso;
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
