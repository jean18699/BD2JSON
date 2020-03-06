package Logico;

import java.util.ArrayList;

public class Libro {

	
	private String titulo;
	private String idioma;
	private int agnoPrimeraEdicion;
	private String casaEditora;
	private String genero;
	private String sipnosis;
	private ArrayList<Autor> autores;
	
	public Libro(String titulo, String idioma, int agnoPrimeraEdicion, String casaEditora, String genero,
			String sipnosis) {
		super();
		
		autores = new ArrayList<Autor>();
		this.titulo = titulo;
		this.idioma = idioma;
		this.agnoPrimeraEdicion = agnoPrimeraEdicion;
		this.casaEditora = casaEditora;
		this.genero = genero;
		this.sipnosis = sipnosis;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getIdioma() {
		return idioma;
	}

	public void setIdioma(String idioma) {
		this.idioma = idioma;
	}

	public int getAgnoPrimeraEdicion() {
		return agnoPrimeraEdicion;
	}
	
	

	public void setAgnoPrimeraEdicion(int agnoPrimeraEdicion) {
		this.agnoPrimeraEdicion = agnoPrimeraEdicion;
	}

	public String getCasaEditora() {
		return casaEditora;
	}

	public void setCasaEditora(String casaEditora) {
		this.casaEditora = casaEditora;
	}

	public String getGenero() {
		return genero;
	}

	public void setGenero(String genero) {
		this.genero = genero;
	}

	public String getSipnosis() {
		return sipnosis;
	}

	public void setSipnosis(String sipnosis) {
		this.sipnosis = sipnosis;
	}

	public ArrayList<Autor> getAutores() {
		return autores;
	}

	public void setAutores(ArrayList<Autor> autores) {
		this.autores = autores;
	}
	
}
