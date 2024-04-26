package com.ucema.progra3.biblioteca.services;

import com.ucema.progra3.biblioteca.model.Libro;
import com.ucema.progra3.biblioteca.repositories.LibroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class LibroServiceImpl implements LibroService{

    @Autowired
    private LibroRepository libroRepository;

    @Override
    @Transactional
    public Libro createLibro(Libro libro) {
        this.libroRepository.save(libro);
        return libro;
    }

    @Override
    @Transactional
    public Libro updateLibro(Libro libro) {
        return this.libroRepository.save(libro);
    }

    @Override
    @Transactional
    public boolean deleteLibro(Libro libro) {
        if(libro == null || libro.getId() == null || !libro.sinPrestamos()){
            return false;
        }
        try {
            this.libroRepository.delete(libro);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    @Override
    @Transactional(readOnly = true)
    public List<Libro> getAll() {
        return (List<Libro>) this.libroRepository.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public List<Libro> getByTitulo(String titulo) {
        return this.libroRepository.findByTitulo(titulo);
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<Libro> getByIsbn(String isbn) {
        return this.libroRepository.findByIsbn(isbn);
    }

    @Override
    @Transactional(readOnly = true)
    public Libro getLibroMasPrestado() {
        return this.libroRepository.findTopByOrderByPrestamosDesc();
    }

    @Override
    public Optional<Libro> getById(Long id) {
        return this.libroRepository.findById(id);
    }
}
