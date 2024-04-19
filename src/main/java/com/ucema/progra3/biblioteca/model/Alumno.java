package com.ucema.progra3.biblioteca.model;

import java.time.LocalDate;

public class Alumno extends Usuario{

    private String carrera;
    private String anio;

    public Alumno(String nombreCompleto, String identificacion, String dni, String email, LocalDate fechaNacimiento, String carrera, String anio) {
        super(nombreCompleto, identificacion, dni, email, fechaNacimiento);
        this.carrera = carrera;
        this.anio = anio;
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
}
