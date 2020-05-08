package edu.escuelaing.arep.usuarios.services;

import java.util.List;

import edu.escuelaing.arep.usuarios.model.Cancion;
import edu.escuelaing.arep.usuarios.model.ListaReproduccion;
import edu.escuelaing.arep.usuarios.model.usuario;

public interface usuarioServices {

	
	usuario getUser (String nickname);
	
	usuario login (String nickname, String password);
	
	void saveUser (usuario user);
	
	List<ListaReproduccion> listasReproduccion (String nickname);
	
	List<Cancion> listasCanciones(String nickname,String nombre);
	
}
