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

    // POST ../api/libro
    @PostMapping(value = "")
    public Libro createLibro(@RequestBody Libro libro) { // @RequestBody indica que el parametro viene en el cuerpo del request, se mapea automaticamente a un objeto Libro
        return libroService.createLibro(libro);
    }

    // PUT ../api/libro
    @PutMapping(value = "")
    public Libro updateLibro(@RequestBody Libro libro) {
        return libroService.updateLibro(libro);
    }

    // DELETE ../api/libro
    @DeleteMapping(value = "")
    public boolean deleteLibro(@RequestBody Libro libro) {
        return libroService.deleteLibro(libro);
    }

    // GET ../api/libro
    @GetMapping(value = "")
    public Iterable<Libro> getAll() {
        return this.libroService.getAll();
    }

    // GET ../api/libro/id/{id} las llaves indican que es un parametro
    @GetMapping(value = "/id/{id}")
    public Libro getById(@PathVariable Long id) {
        return libroService.getById(id).orElse(null);
    }

    // GET ../api/libro?titulo={titulo} las llaves indican que es un parametro, en este caso, parametros de la URL
    @GetMapping(value = "")
    public List<Libro> getByTitulo(@PathVariable(required = true, name = "titulo") String titulo) {
        return libroService.getByTitulo(titulo);
    }

    // GET ../api/libro/isbn/{isbn}
    @GetMapping(value = "/isbn/{isbn}")  //El isbn es un valor que no puede repetirse e indica en especifico un recurso.
    public Libro getByIsbn(@PathVariable String isbn) {
        return libroService.getByIsbn(isbn).orElse(null);
    }


    // GET ../api/libro/masPrestado
    @GetMapping(value = "/masPrestado")
    public Libro getLibroMasPrestado() {
        return libroService.getLibroMasPrestado();
    }


}
