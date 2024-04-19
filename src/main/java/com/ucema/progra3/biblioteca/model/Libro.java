package com.ucema.progra3.biblioteca.model;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

public class Libro {
    private String isbn;
    private String titulo;
    private String autor;
    private String editorial;
    private int anio;

    @Transient
    private List<Prestamo> prestamos;


    public Libro(String isbn, String titulo, String autor, String editorial, int anio) {
        this.isbn = isbn;
        this.titulo = titulo;
        this.autor = autor;
        this.editorial = editorial;
        this.anio = anio;
        this.prestamos = new ArrayList<>();
    }

    public Libro() {

    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public String getEditorial() {
        return editorial;
    }

    public void setEditorial(String editorial) {
        this.editorial = editorial;
    }

    public int getAnio() {
        return anio;
    }

    public void setAnio(int anio) {
        this.anio = anio;
    }

    public List<Prestamo> getPrestamos() {
        return prestamos;
    }

    public void setPrestamos(List<Prestamo> prestamos) {
        this.prestamos = prestamos;
    }
}
