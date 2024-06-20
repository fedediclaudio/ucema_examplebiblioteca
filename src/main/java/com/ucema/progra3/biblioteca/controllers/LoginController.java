package com.ucema.progra3.biblioteca.controllers;

import com.ucema.progra3.biblioteca.dto.LoginDTO;
import com.ucema.progra3.biblioteca.services.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/api/login")
@CrossOrigin(origins = "*")
public class LoginController {

    @Autowired
    private UsuarioService usuarioService;

    @PostMapping("")
    public boolean login(@RequestBody LoginDTO dto) {
        System.out.println("LoginController.login");
        System.out.println(dto.getUsername());
        System.out.println(dto.getPassword());
        return this.usuarioService.checkLogin(dto.getUsername(), dto.getPassword());
    }

}
