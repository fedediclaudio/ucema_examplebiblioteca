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

    @Column(nullable = false, name = "fecha_solicitud")
    private LocalDate fechaSolicitud;

    @Column(name = "fecha_devolucion", nullable = false)
    private LocalDate fechaDevolucion;

    private boolean devuelto;

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


    public Prestamo(LocalDate fechaSolicitud, LocalDate fechaDevolucion, Usuario usuario, List<Libro> libros) {
        this.fechaSolicitud = fechaSolicitud;
        this.usuario = usuario;
        this.fechaDevolucion = fechaDevolucion;
        this.devuelto = false;
        this.libros = libros;
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

    public boolean isDevuelto() {
        return devuelto;
    }

    public void setDevuelto(boolean devuelto) {
        this.devuelto = devuelto;
    }

    public void setLibros(List<Libro> libros) {
        this.libros = libros;
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
