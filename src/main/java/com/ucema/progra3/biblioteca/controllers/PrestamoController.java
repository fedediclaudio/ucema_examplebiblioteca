package com.ucema.progra3.biblioteca.controllers;

import com.ucema.progra3.biblioteca.dto.NewPrestamoDTO;
import com.ucema.progra3.biblioteca.model.Prestamo;
import com.ucema.progra3.biblioteca.services.PrestamoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/api/prestamo")
@CrossOrigin(origins = "*", methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE})
public class PrestamoController {

    @Autowired
    private PrestamoService prestamoService;

    @PostMapping(value = "")
    public Prestamo createPrestamo(@RequestBody NewPrestamoDTO prestamo) {
        return prestamoService.createPrestamo(prestamo.getFechaSolicitud(), prestamo.getUsuario(), prestamo.getLibros());
    }

    @PutMapping(value = "")
    public Prestamo updatePrestamo(@RequestBody Prestamo prestamo) {
        return prestamoService.updatePrestamo(prestamo);
    }

    @GetMapping(value = "/{id}")
    public Prestamo getPrestamoById(@PathVariable Long id) {
        return prestamoService.getPrestamoById(id);
    }

    @GetMapping(value = "/usuario/{nombre}")
    public List<Prestamo> getPrestamoByUsuario(@PathVariable String nombre) {
        return prestamoService.getPrestamoByUsuario(nombre);
    }

    @GetMapping(value = "/devolucion10dias")
    public List<Prestamo> getPrestamoADevolverEn10Dias() {
        return prestamoService.getPrestamoADevolverEn10Dias();
    }

    @PutMapping(value = "/devolucion")
    public void registarDevolucion(@RequestBody Prestamo prestamo) {
        prestamoService.registarDevolucion(prestamo);
    }

}