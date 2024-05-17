package com.ucema.progra3.biblioteca.services;

import com.ucema.progra3.biblioteca.model.*;

import java.time.LocalDate;
import java.util.Optional;

public interface UsuarioService {

    Alumno createAlumno(Alumno alumno);

    Profesor createProfesor(Profesor profesor);

    Usuario updateUsuario(Usuario usuario);

    boolean deleteUsuario(Usuario usuario);

    Optional<Usuario> getByDni(String dni);

    String authenticate(String username, String password);

    Usuario getUserInfo();
}
