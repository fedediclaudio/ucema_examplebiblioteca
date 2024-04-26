package com.ucema.progra3.biblioteca.services;

import com.ucema.progra3.biblioteca.model.*;

import java.time.LocalDate;
import java.util.Optional;

public interface UsuarioService {

    Alumno createAlumno(String nombreCompleto, String identificacion, String dni, String email, LocalDate fechaNacimiento, String carrera, String anio);

    Profesor createProfesor(String nombreCompleto, String identificacion, String dni, String email, LocalDate fechaNacimiento, LocalDate fechaIngreso);

    Usuario updateUsuario(Usuario usuario);

    boolean deleteUsuario(Usuario usuario);

    Optional<Usuario> getByDni(String dni);

}
