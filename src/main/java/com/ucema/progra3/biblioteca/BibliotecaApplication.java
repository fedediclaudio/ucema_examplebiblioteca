package com.ucema.progra3.biblioteca;

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
	CommandLineRunner init() {
		return (args) -> {
			System.out.println("BibliotecaApplication started");
		};
	}

}
