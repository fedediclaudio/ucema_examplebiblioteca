package com.ucema.progra3.biblioteca.services;

import com.ucema.progra3.biblioteca.model.Alumno;
import com.ucema.progra3.biblioteca.model.Profesor;
import com.ucema.progra3.biblioteca.model.Usuario;
import com.ucema.progra3.biblioteca.repositories.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.LocalDate;
import java.util.Optional;

public class UsuarioServiceImpl implements UsuarioService{

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Override
    public Alumno createAlumno(String nombreCompleto, String identificacion, String dni, String email, LocalDate fechaNacimiento, String carrera, String anio) {
        Alumno alumno = new Alumno(nombreCompleto, identificacion, dni, email, fechaNacimiento, carrera, anio);
        return usuarioRepository.save(alumno);
    }

    @Override
    public Profesor createProfesor(String nombreCompleto, String identificacion, String dni, String email, LocalDate fechaNacimiento, LocalDate fechaIngreso) {
        Profesor profesor = new Profesor(nombreCompleto, identificacion, dni, email, fechaNacimiento, fechaIngreso);
        return usuarioRepository.save(profesor);
    }

    @Override
    public Usuario updateUsuario(Usuario usuario) {
        return usuarioRepository.save(usuario);
    }

    @Override
    public boolean deleteUsuario(Usuario usuario) {
        if(usuario.tienePrestamos()) {
            return false;
        }
        try {
            usuarioRepository.delete(usuario);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    @Override
    public Optional<Usuario> getByDni(String dni) {
        return this.usuarioRepository.findByDni(dni);
    }
}
