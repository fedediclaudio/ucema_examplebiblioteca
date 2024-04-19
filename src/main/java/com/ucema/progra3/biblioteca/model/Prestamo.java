package com.ucema.progra3.biblioteca.model;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Prestamo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private LocalDate fechaSolicitud;
    private LocalDate fechaDevolucion;

    @ManyToOne
    @JoinColumn(name = "id_usuario", nullable = false)
    private Usuario usuario;

    @ManyToMany
    @JoinTable(
            name = "prestamo_libro",
            joinColumns = @JoinColumn(name = "id_prestamo"),
            inverseJoinColumns = @JoinColumn(name = "id_libro")
    )
    private List<Libro> libros;


    public Prestamo(LocalDate fechaSolicitud, Usuario usuario, Libro libro) {
        this.fechaSolicitud = fechaSolicitud;
        this.usuario = usuario;
        this.fechaDevolucion = usuario.calcularFechaDevolucion(fechaSolicitud);
        this.libros = new ArrayList<>();
    }

    public Prestamo() {

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

    public List<Libro> getLibros() {
        return libros;
    }

    public void setLibro(List<Libro> libro) {
        this.libros = libro;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }
}
