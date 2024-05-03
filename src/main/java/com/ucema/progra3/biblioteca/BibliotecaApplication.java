package com.ucema.progra3.biblioteca;

import com.ucema.progra3.biblioteca.model.Libro;
import com.ucema.progra3.biblioteca.services.LibroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

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
	CommandLineRunner init(@Autowired LibroService libroService) {
		return (args) -> {
		 	libroService.createLibro(new Libro("0000001111", "1984", "Orwell", "una editorial", 1948));
			libroService.createLibro(new Libro("0000001113", "El Aleph", "Borges", "una editorial", 1949));
			libroService.createLibro(new Libro("0000001114", "El principito", "Saint-Exupery", "una editorial", 1943));
			libroService.createLibro(new Libro("0000001115", "El señor de los anillos", "Tolkien", "una editorial", 1954));
			System.out.println("BibliotecaApplication started");
		};
	}

}
