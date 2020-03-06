package Logico;

import java.util.ArrayList;

public class Libreria {

	ArrayList<Libro> libros;
	ArrayList<Autor> autores;
	private static Libreria libreria;
	
	public Libreria()
	{
		libros = new ArrayList<Libro>();
		autores = new ArrayList<Autor>();
	}

	
	public void addLibro(Libro libro)
	{
		libros.add(libro);
	}
	
	public static Libreria getInstance() {
		if (libreria == null) {
			libreria = new Libreria();
		}
		return libreria;
	}
	
	public Autor getAutorByName(String name)
	{
		Autor autor = null;
		
		for(int i = 0; i < autores.size(); i++)
		{
			if(autores.get(i).getNombre().contentEquals(name))
			{
				
				autor = autores.get(i);
			}
		}
		
		return autor;
		
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
