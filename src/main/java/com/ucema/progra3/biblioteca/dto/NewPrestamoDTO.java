package com.ucema.progra3.biblioteca.dto;

import com.ucema.progra3.biblioteca.model.Libro;
import com.ucema.progra3.biblioteca.model.Usuario;

import java.time.LocalDate;
import java.util.List;

public class NewPrestamoDTO {

    private LocalDate fechaSolicitud;
    private Usuario usuario;
    private List<Libro> libros;

    public NewPrestamoDTO(LocalDate fechaSolicitud, Usuario usuario, List<Libro> libros) {
        this.fechaSolicitud = fechaSolicitud;
        this.usuario = usuario;
        this.libros = libros;
    }

    public LocalDate getFechaSolicitud() {
        return fechaSolicitud;
    }

    public void setFechaSolicitud(LocalDate fechaSolicitud) {
        this.fechaSolicitud = fechaSolicitud;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public List<Libro> getLibros() {
        return libros;
    }

    public void setLibros(List<Libro> libros) {
        this.libros = libros;
    }
}
