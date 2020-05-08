package edu.escuelaing.arep.usuarios.model;



public class Cancion {
	

	private int id;
	

	private String contenido;
	

	private String nombre;
	
	
	public Cancion () {
		
	}
	
	public Cancion (int id,String contenido,String nombre) {
		this.id = id;
		this.contenido = contenido;
		this.nombre = nombre;
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getContenido() {
		return contenido;
	}


	public void setContenido(String contenido) {
		this.contenido = contenido;
	}


	public String getNombre() {
		return nombre;
	}


	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	

}