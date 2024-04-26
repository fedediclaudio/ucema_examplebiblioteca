package com.ucema.progra3.biblioteca.services;

import com.ucema.progra3.biblioteca.model.Libro;
import com.ucema.progra3.biblioteca.model.Prestamo;
import com.ucema.progra3.biblioteca.model.Usuario;

import java.time.LocalDate;
import java.util.List;

public interface PrestamoService {

    Prestamo createPrestamo(LocalDate fechaSolicitud, Usuario usuario, List<Libro> libros);

    Prestamo updatePrestamo(Prestamo prestamo);

    Prestamo getPrestamoById(Long id);

    List<Prestamo> getPrestamoByUsuario(String nombre);

    List<Prestamo> getPrestamoADevolverEn10Dias();

    void registarDevolucion(Prestamo prestamo);

}
