package edu.escuelaing.arep.usuarios.model;


public class usuario {

	private String nickname;

	private String nombre;
	
	private String password;
	
	public usuario() {
		
	}
	
	public usuario(String nickname,String nombre,String password) {
		this.nickname = nickname;
		this.nombre = nombre;
		this.password = password;
	}

	public String getNickname() {
		return nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
}
