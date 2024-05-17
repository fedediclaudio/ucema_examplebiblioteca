package com.ucema.progra3.biblioteca.services;

import com.ucema.progra3.biblioteca.model.Libro;
import com.ucema.progra3.biblioteca.model.Prestamo;
import com.ucema.progra3.biblioteca.model.Usuario;
import com.ucema.progra3.biblioteca.repositories.LibroRepository;
import com.ucema.progra3.biblioteca.repositories.PrestamoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.List;

@Service
public class PrestamoServiceImpl implements PrestamoService{

    @Autowired
    private PrestamoRepository prestamoRepository;

    @Autowired
    private LibroRepository libroRepository;

    @Override
    @Transactional
    /**
     * Notar que en este caso existe una logica de aplicación a implementar en el SERVICIO
     */
    public Prestamo createPrestamo(LocalDate fechaSolicitud, Usuario usuario, List<Libro> libros) {
        LocalDate fechaDevolucion = usuario.calcularFechaDevolucion(fechaSolicitud);
        Prestamo prestamo = new Prestamo(fechaSolicitud, fechaDevolucion, usuario, libros);
        for (Libro libro : prestamo.getLibros()) {
            libro.setEstado("PRESTADO");
            this.libroRepository.save(libro);
        }
        this.prestamoRepository.save(prestamo);
        return prestamo;
    }

    @Override
    @Transactional
    public Prestamo updatePrestamo(Prestamo prestamo) {
        return this.prestamoRepository.save(prestamo);
    }

    @Override
    @Transactional(readOnly = true)
    public Prestamo getPrestamoById(Long id) {
        return this.prestamoRepository.findById(id).orElse(null);
    }

    @Override
    @Transactional(readOnly = true)
    public List<Prestamo> getPrestamoByUsuario(String nombre) {
        return this.prestamoRepository.findByUsuario_NombreCompleto(nombre);
    }

    @Override
    @Transactional(readOnly = true)
    public List<Prestamo> getPrestamoADevolverEn10Dias() {
        return this.prestamoRepository.findByFechaDevolucionBefore(LocalDate.now().plusDays(10));
    }

    @Override
    @Transactional
    public void registarDevolucion(Prestamo prestamo) {
        for(Libro libro : prestamo.getLibros()){
            libro.setEstado("DISPONIBLE");
            this.libroRepository.save(libro);
        }
        prestamo.setDevuelto(true);
        this.prestamoRepository.save(prestamo);
    }

    @Override
    public List<Prestamo> getPrestamosUser() {
        // Obtengo el usuario autenticado desde el contexto de Spring Security
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (authentication == null || !authentication.isAuthenticated()) {
            return null;
        }
        Usuario usuario = (Usuario) authentication.getPrincipal(); //Obtengo el usuario autenticado
        String name = authentication.getName(); //Obtengo el nombre del usuario autenticado
        return this.prestamoRepository.findByUsuario_Username(usuario.getUsername());
    }
}
