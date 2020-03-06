package Logico;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Reader;
import java.util.ArrayList;
import java.util.Collections;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

//import com.google.gson.Gson;
//import com.google.gson.JsonIOException;

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
			
	        Gson gson = new GsonBuilder().setPrettyPrinting().create();
	        
			if(new File("lib.json").length() > 0)
			{
		        try (Reader reader = new FileReader("lib.json")) {
		        	
		        	Collections.addAll(libreria.libros, gson.fromJson(reader, Libro[].class));
					
		        } catch (IOException e) {
		            e.printStackTrace();
		        }
			}
			
			if(new File("aut.json").length() > 0)
			{
		        try (Reader reader = new FileReader("aut.json")) {
		        	
		        	Collections.addAll(libreria.autores, gson.fromJson(reader, Autor[].class));
					
		        } catch (IOException e) {
		            e.printStackTrace();
		        }
			}
			
		}
		return libreria;
	}
	
//	public void SaveData() throws JsonIOException, IOException
//	{
//		
//	}
	
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
