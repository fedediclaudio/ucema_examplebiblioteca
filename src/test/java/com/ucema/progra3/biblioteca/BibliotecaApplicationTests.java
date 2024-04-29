package com.ucema.progra3.biblioteca;

import com.ucema.progra3.biblioteca.model.Libro;
import com.ucema.progra3.biblioteca.services.LibroService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.util.Assert;

import java.util.List;
import java.util.Objects;

@SpringBootTest
class BibliotecaApplicationTests {

	@Autowired
	private LibroService libroService;

	@Test
	void contextLoads() {
	}

	@Test
	void init(){

	}

	/**
	 * Pueden utilizarse los tests para probar el funcionamiento de los métodos de la clase LibroService
	 * La clase LibroService es inyectada en esta clase de test y puede probarse sus metodos
	 * Se añade un test de ejemplo de como utilizarlo.
	 */

	@Test
	void createAndGetLibroTest() {
		Libro libro1 = this.libroService.createLibro("0000001111", "Cien años de soledad", "Garcia Marquez", "una editorial", 1982);
		Assert.notNull(libro1.getId(), "No se ha asignado un id");

		Libro libro2 = this.libroService.createLibro("0000001112", "1984", "George Orwell", "una editorial", 1949);

		List<Libro> list1 = this.libroService.getAll();
		Assert.isTrue(list1.size() == 2, "No se han obtenido los libros correctamente");

		List<Libro> list2 = this.libroService.getByTitulo("1984");
		Assert.isTrue(list2.size() == 1, "No se han obtenido los libros correctamente");
		Assert.isTrue(Objects.equals(list2.get(0).getIsbn(), "0000001112"), "No se han obtenido los libros correctamente");
	}

}
