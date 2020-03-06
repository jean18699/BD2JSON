package Logico;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;

public class Autor implements Serializable {

	private Date fechaNacimiento;
	private String nombre;
	private Date fechaDefuncion;
	private String lugarNacimiento;
	private String nacionalidad;
	private String sexo;
	private ArrayList<String> librosPublicados;
	
	public Autor(Date fechaNacimiento, String nombre, Date fechaFuncion, String lugarNacimiento, String nacionalidad,
			String sexo) {
		super();
		
		librosPublicados = new ArrayList<String>();
		this.fechaNacimiento = fechaNacimiento;
		this.nombre = nombre;
		this.fechaDefuncion = fechaFuncion;
		this.lugarNacimiento = lugarNacimiento;
		this.nacionalidad = nacionalidad;
		this.sexo = sexo;
	}

	public Date getFechaNacimiento() {
		return fechaNacimiento;
	}

	public void addLibroPublicado(String nombreLibro)
	{
		librosPublicados.add(nombreLibro);
	}
	
	
	public void setFechaNacimiento(Date fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Date getFechaFuncion() {
		return fechaDefuncion;
	}

	public void setFechaFuncion(Date fechaFuncion) {
		this.fechaDefuncion = fechaFuncion;
	}

	public String getLugarNacimiento() {
		return lugarNacimiento;
	}

	public void setLugarNacimiento(String lugarNacimiento) {
		this.lugarNacimiento = lugarNacimiento;
	}

	public String getNacionalidad() {
		return nacionalidad;
	}

	public void setNacionalidad(String nacionalidad) {
		this.nacionalidad = nacionalidad;
	}

	public String getSexo() {
		return sexo;
	}

	public void setSexo(String sexo) {
		this.sexo = sexo;
	}
	
	
	
}