package com.ucema.progra3.biblioteca.services;

import com.ucema.progra3.biblioteca.model.Usuario;
import com.ucema.progra3.biblioteca.repositories.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<Usuario> optionalUsuario = this.usuarioRepository.findByUsername(username);
        if(optionalUsuario.isEmpty()) {
            throw new UsernameNotFoundException("Usuario no encontrado");
        } else {
            Usuario usuario = optionalUsuario.get();
            return usuario;
        }
    }
}
