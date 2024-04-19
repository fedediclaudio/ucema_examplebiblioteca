package com.ucema.progra3.biblioteca.model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public abstract class Usuario {

    private String nombreCompleto;
    private String identificacion;
    private String dni;
    private String email;
    private LocalDate fechaNacimiento;
    private List<Prestamo> prestamos;

    public Usuario(String nombreCompleto, String identificacion, String dni, String email, LocalDate fechaNacimiento) {
        this.nombreCompleto = nombreCompleto;
        this.identificacion = identificacion;
        this.dni = dni;
        this.email = email;
        this.fechaNacimiento = fechaNacimiento;
        this.prestamos = new ArrayList<>();
    }

    public String getNombreCompleto() {
        return nombreCompleto;
    }

    public void setNombreCompleto(String nombreCompleto) {
        this.nombreCompleto = nombreCompleto;
    }

    public String getIdentificacion() {
        return identificacion;
    }

    public void setIdentificacion(String identificacion) {
        this.identificacion = identificacion;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public LocalDate getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(LocalDate fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public List<Prestamo> getPrestamos() {
        return prestamos;
    }

    public void setPrestamos(List<Prestamo> prestamos) {
        this.prestamos = prestamos;
    }

    public abstract LocalDate calcularFechaDevolucion(LocalDate date);
}
