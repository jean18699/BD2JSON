package Logico;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.Reader;
import java.util.ArrayList;
import java.util.List;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import com.google.gson.*;

public class ObjectToJson {
	
	@SuppressWarnings("unchecked")
	public static void main(String[] args) throws JsonIOException, IOException {
	    // Creating object of Organisation 
	    Libro lib = new Libro("Little Women", "Inglés", 1987, "Santillana", "Romance", "Muy interesante");
	    Libro lib3 = new Libro("Little Women 3", "Inglés 3", 1857, "Santillana 3", "Romance 3", "Muy interesante 3");
	    
	    List<Libro> arregloLibros = new ArrayList<Libro>();
	    
	    arregloLibros.add(lib);
	    arregloLibros.add(lib3);
	 
	    
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        
        
//         Java objects to File
        try (FileWriter writer = new FileWriter("lib.json")) {
            gson.toJson(arregloLibros, writer);
        } catch (IOException e) {
            e.printStackTrace();
        }
        
        try (Reader reader = new FileReader("lib.json")) {

            // Convert JSON File to Java Object
        	Libro[] arregloLibros2 = gson.fromJson(reader, Libro[].class);
			
			// print staff 
            System.out.println(arregloLibros2[1]);

        } catch (IOException e) {
            e.printStackTrace();
        }

    }
        
        
    
}
