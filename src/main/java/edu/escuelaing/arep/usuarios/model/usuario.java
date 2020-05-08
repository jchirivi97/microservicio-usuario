package edu.escuelaing.arep.usuarios.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name="usuario")
public class usuario {

	@Id
	@NotNull
	@Column(name="nickname")
	private String nickname;
	
	

	@Column(name="nombre")
	@Size(min=1,max=100)
	private String nombre;
	
	@Column(name="password")
	@Size(min=1,max=100)
	private String password;
		

	public usuario() {
		
	}
	
	public usuario(String nickname,String nombre) {
		this.nickname = nickname;
		this.nombre = nombre;
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
