package com.ucema.progra3.biblioteca.controllers;

import com.ucema.progra3.biblioteca.model.Alumno;
import com.ucema.progra3.biblioteca.model.Profesor;
import com.ucema.progra3.biblioteca.model.Usuario;
import com.ucema.progra3.biblioteca.services.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/api/usuario")
@CrossOrigin(origins = "*", methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE})
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;

    // POST ../api/usuario/alumno
    @PostMapping(value = "/alumno")
    public Usuario createAlumno(@RequestBody Alumno usuario) {
        return usuarioService.createAlumno(usuario);
    }

    // POST ../api/usuario/profesor
    @PostMapping(value = "/profesor")
    public Usuario createProfesor(@RequestBody Profesor usuario) {
        return usuarioService.createProfesor(usuario);
    }

    // PUT ../api/usuario
    @PutMapping(value = "")
    public Usuario updateUsuario(@RequestBody Usuario usuario) {
        return usuarioService.updateUsuario(usuario);
    }

    // DELETE ../api/usuario
    @DeleteMapping(value = "")
    public boolean deleteUsuario(@RequestBody Usuario usuario) {
        return usuarioService.deleteUsuario(usuario);
    }

    // GET ../api/usuario/dni/{dni}
    @GetMapping(value = "dni/{dni}")
    public Usuario getByDni(@PathVariable String dni) {
        return usuarioService.getByDni(dni).orElse(null);
    }

    /**
     * Endpoint para obtener la información del usuario logueado mediante jwt
     */
    @GetMapping(value = "/info")
    public Usuario getUserInfo() {
        return usuarioService.getUserInfo();
    }

}
