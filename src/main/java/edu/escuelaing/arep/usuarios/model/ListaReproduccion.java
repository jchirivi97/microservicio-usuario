package edu.escuelaing.arep.usuarios.model;


public class ListaReproduccion {

	
	private int id;
	
	private String nombre;
	
	private int idcancion;
	
	private String usuario;
	
	
	public ListaReproduccion() {
		
	}
	
	public ListaReproduccion(String nombre, int idcancion, String usuario) {
		this.nombre = nombre;
		this.idcancion = idcancion;
		this.usuario = usuario;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getIdcancion() {
		return idcancion;
	}

	public void setIdcancion(int idcancion) {
		this.idcancion = idcancion;
	}

	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

}