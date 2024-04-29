package com.ucema.progra3.biblioteca.repositories;

import com.ucema.progra3.biblioteca.model.Libro;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface LibroRepository extends CrudRepository<Libro, Long> {

    /**
     * Algunos metodos de ejemplos...
     * Notar que no es necesario generar una implementación, Spring Data JPA los implementa por nosotros
     * Segun el nombre del metodo, Spring Data JPA genera la consulta SQL correspondiente
     */

    Optional<Libro> findByIsbn(String isbn);

    List<Libro> findByAutor(String autor);

    List<Libro> findByTitulo(String titulo);

    List<Libro> findByAutorAndAnio(String autor, int anio);

    List<Libro> findByAnioEquals(int anio);

    List<Libro> findByAnioGreaterThan(int anio);

    Libro findTopByOrderByPrestamosDesc();
}


