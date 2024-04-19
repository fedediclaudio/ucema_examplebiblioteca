package com.ucema.progra3.biblioteca.model;

import java.time.LocalDate;

public class Prestamo {
    private LocalDate fechaSolicitud;
    private LocalDate fechaDevolucion;
    private Usuario usuario;
    private Libro libro;

    public Prestamo(LocalDate fechaSolicitud, Usuario usuario, Libro libro) {
        this.fechaSolicitud = fechaSolicitud;
        this.usuario = usuario;
        this.fechaDevolucion = usuario.calcularFechaDevolucion(fechaSolicitud);
        this.libro = libro;
    }

    public LocalDate getFechaSolicitud() {
        return fechaSolicitud;
    }

    public void setFechaSolicitud(LocalDate fechaSolicitud) {
        this.fechaSolicitud = fechaSolicitud;
    }

    public LocalDate getFechaDevolucion() {
        return fechaDevolucion;
    }

    public void setFechaDevolucion(LocalDate fechaDevolucion) {
        this.fechaDevolucion = fechaDevolucion;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Libro getLibro() {
        return libro;
    }

    public void setLibro(Libro libro) {
        this.libro = libro;
    }
}
