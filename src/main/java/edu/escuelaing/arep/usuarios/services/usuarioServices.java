package edu.escuelaing.arep.usuarios.services;

import java.util.List;

import edu.escuelaing.arep.usuarios.model.usuario;

public interface usuarioServices {

	
	usuario getUser (String nickname);
	
	usuario login (String nickname, String password);
	
	void saveUser (usuario user);
}
