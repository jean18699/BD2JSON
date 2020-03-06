package Logico;

import java.util.ArrayList;

public class Libreria {

	ArrayList<Libro> libros;
	ArrayList<Autor> autores;
	
	public Libreria()
	{
		libros = new ArrayList<Libro>();
		autores = new ArrayList<Autor>();
	}

	
	public void addLibro(Libro libro)
	{
		libros.add(libro);
	}

	public void addAutor(Autor autor)
	{
		autores.add(autor);
	}
	
	public ArrayList<Libro> getLibros() {
		return libros;
	}


	public ArrayList<Autor> getAutores() {
		return autores;
	}
	

	
	

}
