package Logico;

import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import com.fasterxml.jackson.core.JsonParser;
import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonIOException;
import com.google.gson.JsonObject;

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
	
	public void SaveData()
	{
		
		//FileOutputStream saveFile = new FileOutputStream("libreria.sav");
		
/*		Gson g = new Gson();
		
		JsonArray libreriaJSON = new JsonArray();
		
		String str = g.toJson(/*Libreria.getInstance()libreria);
		
		libreriaJSON.add(str);
		
		try(FileWriter file = new FileWriter("libreria.json")){
			
			file.write(libreriaJSON.toString());
			file.flush();
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println(str);
		*/
	}
	
	public void loadData()
	{
		
		
		
		
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
