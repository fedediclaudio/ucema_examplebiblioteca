package com.ucema.progra3.biblioteca.services;

import com.ucema.progra3.biblioteca.model.Alumno;
import com.ucema.progra3.biblioteca.model.Profesor;
import com.ucema.progra3.biblioteca.model.Usuario;
import com.ucema.progra3.biblioteca.repositories.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.Optional;

@Service
public class UsuarioServiceImpl implements UsuarioService{

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    @Transactional
    public Alumno createAlumno(Alumno alumno) {
        alumno.setPassword(passwordEncoder.encode(alumno.getPassword()));
        return usuarioRepository.save(alumno);
    }

    @Override
    @Transactional
    public Profesor createProfesor(Profesor profesor) {
        profesor.setPassword(passwordEncoder.encode(profesor.getPassword()));
        return usuarioRepository.save(profesor);
    }

    @Override
    @Transactional
    public Usuario updateUsuario(Usuario usuario) {
        return usuarioRepository.save(usuario);
    }

    @Override
    @Transactional
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
