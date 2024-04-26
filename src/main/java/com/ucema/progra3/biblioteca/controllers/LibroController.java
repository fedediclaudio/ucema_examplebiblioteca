package com.ucema.progra3.biblioteca.controllers;

import com.ucema.progra3.biblioteca.model.Libro;
import com.ucema.progra3.biblioteca.services.LibroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/api/libro")
@CrossOrigin(origins = "*", methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE})
public class LibroController {

    @Autowired
    private LibroService libroService;

    @PostMapping(value = "")
    public Libro createLibro(@RequestBody Libro libro) {
        return libroService.createLibro(libro);
    }

    @PutMapping(value = "")
    public Libro updateLibro(@RequestBody Libro libro) {
        return libroService.updateLibro(libro);
    }

    @DeleteMapping(value = "")
    public boolean deleteLibro(@RequestBody Libro libro) {
        return libroService.deleteLibro(libro);
    }

    @GetMapping(value = "")
    public Iterable<Libro> getAll() {
        return this.libroService.getAll();
    }

    @GetMapping(value = "/id/{id}")
    public Libro getById(@PathVariable Long id) {
        return libroService.getById(id).orElse(null);
    }

    @GetMapping(value = "")
    public List<Libro> getByTitulo(@PathVariable(required = true, name = "titulo") String titulo) {
        return libroService.getByTitulo(titulo);
    }

    @GetMapping()

    @GetMapping(value = "/isbn/{isbn}")
    public Libro getByIsbn(@PathVariable String isbn) {
        return libroService.getByIsbn(isbn).orElse(null);
    }

    @GetMapping(value = "/masPrestado")
    public Libro getLibroMasPrestado() {
        return libroService.getLibroMasPrestado();
    }


}
