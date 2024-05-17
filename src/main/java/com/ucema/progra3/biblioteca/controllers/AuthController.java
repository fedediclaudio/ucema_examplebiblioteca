package com.ucema.progra3.biblioteca.controllers;


import com.ucema.progra3.biblioteca.dto.LoginDTO;
import com.ucema.progra3.biblioteca.dto.ResponseLoginDTO;
import com.ucema.progra3.biblioteca.services.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/api/auth")
@CrossOrigin(origins = "*", methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE})
public class AuthController {

    @Autowired
    private UsuarioService userService;

    @PostMapping(path = "/login")
    public ResponseLoginDTO authenticate(@RequestBody LoginDTO loginDTO) {
        return new ResponseLoginDTO(this.userService.authenticate(loginDTO.getUsername(), loginDTO.getPassword()));
    }

}
