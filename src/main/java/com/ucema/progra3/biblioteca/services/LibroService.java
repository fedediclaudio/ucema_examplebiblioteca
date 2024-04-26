package com.ucema.progra3.biblioteca.services;

import com.ucema.progra3.biblioteca.model.*;

import java.util.List;
import java.util.Optional;

public interface LibroService {

    Libro createLibro(Libro libro);

    Libro updateLibro(Libro libro);

    boolean deleteLibro(Libro libro);

    List<Libro> getAll();

    List<Libro> getByTitulo(String titulo);

    Optional<Libro> getByIsbn(String isbn);

    Libro getLibroMasPrestado();

    Optional<Libro> getById(Long id);
}
