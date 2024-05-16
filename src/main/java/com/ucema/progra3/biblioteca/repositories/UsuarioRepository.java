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

    /**
     * En este caso, la consulta es un poco más compleja, Spring Data JPA no puede generarla automáticamente
     * Puede definirse mediante la anotación @Query y escribir la consulta JPQL correspondiente
     * JPQL (Java Persistance Query Lenguage) es un lenguaje de consultas orientado a objetos, similar a HQL (Hibernate Query Language).
     */
    @Query("select u from Usuario u join u.prestamos p join p.libros l " +
            "group by u order by count(*)")
    List<Prestamo> getUsuariosOrdenadosPorCantidadDeLibrosPedidos();

    Optional<Usuario> findByDni(String dni);

    Optional<Usuario> findByUsername(String username);
}
