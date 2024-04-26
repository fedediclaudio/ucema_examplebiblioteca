package com.ucema.progra3.biblioteca.repositories;

import com.ucema.progra3.biblioteca.model.Prestamo;
import com.ucema.progra3.biblioteca.model.Usuario;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UsuarioRepository extends CrudRepository<Usuario, Long> {

    @Query("select u from Usuario u join u.prestamos p join p.libros l " +
            "group by u order by count(*)")
    List<Prestamo> getUsuariosOrdenadosPorCantidadDeLibrosPedidos();

    Optional<Usuario> findByDni(String dni);
}
