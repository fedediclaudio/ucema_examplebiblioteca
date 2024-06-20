package com.ucema.progra3.biblioteca;

import com.ucema.progra3.biblioteca.model.Alumno;
import com.ucema.progra3.biblioteca.model.Libro;
import com.ucema.progra3.biblioteca.model.Prestamo;
import com.ucema.progra3.biblioteca.model.Profesor;
import com.ucema.progra3.biblioteca.services.LibroService;
import com.ucema.progra3.biblioteca.services.PrestamoService;
import com.ucema.progra3.biblioteca.services.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
public class BibliotecaApplication {

	public static void main(String[] args) {
		SpringApplication.run(BibliotecaApplication.class, args);
	}

	/**
	 * Metodo que se ejecuta al iniciar la aplicacion, puedo utilizarlo para incializar con algunos datos de prueba
	 * Como parametros puedo inyectar cualquier servicio o clase inyectable utilizando @Autowired
	 */
	@Bean
	CommandLineRunner init(@Autowired LibroService libroService, @Autowired UsuarioService usuarioService, @Autowired PrestamoService prestamoService) {
		return (args) -> {
			Alumno alumno1 = usuarioService.createAlumno(new Alumno("alumno1", "1234", "Juan", "100", "40000000", "emailalumno1@gmail.com", null, "Ingenieria", "1er año"));
			Alumno alumno2 = usuarioService.createAlumno(new Alumno("alumno2", "1234", "Pedro", "101", "40000001", "emailalumno2@gmail.com", null, "Economia", "2do año"));
			usuarioService.createProfesor(new Profesor("profesor1", "1234", "Carlos", "200", "30000000", "emailprofesor1@gmail.com", null, null));
			Libro libro1 = libroService.createLibro(new Libro("0000001111", "1984", "Orwell", "una editorial", 1948));
			Libro libro2 = libroService.createLibro(new Libro("0000001113", "El Aleph", "Borges", "una editorial", 1949));
			Libro libro3 = libroService.createLibro(new Libro("0000001114", "El principito", "Saint-Exupery", "una editorial", 1943));
			Libro libro4 = libroService.createLibro(new Libro("0000001115", "El señor de los anillos", "Tolkien", "una editorial", 1954));
			Prestamo prestamo1 = prestamoService.createPrestamo(LocalDate.now(), alumno1, new ArrayList<>(List.of(libro1, libro3)));
			Prestamo prestamo2 = prestamoService.createPrestamo(LocalDate.now(), alumno1, new ArrayList<>(List.of(libro2)));
			Prestamo prestamo3 = prestamoService.createPrestamo(LocalDate.now(), alumno2, new ArrayList<>(List.of(libro4)));
			System.out.println("BibliotecaApplication started");
		};
	}

}
