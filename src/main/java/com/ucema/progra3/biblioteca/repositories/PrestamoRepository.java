package com.ucema.progra3.biblioteca.repositories;

import com.ucema.progra3.biblioteca.model.Prestamo;
import com.ucema.progra3.biblioteca.model.Usuario;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface PrestamoRepository extends CrudRepository<Prestamo, Long> {

    List<Prestamo> findByUsuario(Usuario usuario);

    List<Prestamo> findByLibros_Isbn(String isbn);

    List<Prestamo> findByUsuario_DniAndLibros_Titulo(String dni, String libro);

    List<Prestamo> findByFechaDevolucionBefore(LocalDate fechaDevolucion);

    List<Prestamo> findByFechaSolicitudBetween(LocalDate fechaInicial, LocalDate fechaFinal);

    List<Prestamo> findByUsuario_NombreCompleto(String nombre);

    List<Prestamo> findByUsuario_Username(String username);
}
