package edu.escuelaing.arep.usuarios.services.impl;

import org.springframework.stereotype.Service;

import edu.escuelaing.arep.usuarios.model.usuario;
import edu.escuelaing.arep.usuarios.recovery.usuarioRepository;
import edu.escuelaing.arep.usuarios.services.usuarioServices;

@Service
public class usuarioServicesImpl implements usuarioServices {
	
	usuarioRepository usuarioRepo;
	
	private void dataBase() {
		usuarioRepo = new usuarioRepository();
	}

	@Override
	public usuario getUser(String nickname) {
		dataBase();
		return usuarioRepo.getUser(nickname);
	}

	@Override
	public void saveUser(String nickname,String nombre, String password) {
		dataBase();
		usuarioRepo.saveUser(nickname, nombre, password);		
	}
	
	@Override
	public usuario login(String nickname, String password) {
		dataBase();
		return usuarioRepo.getLogin(nickname, password);
	}

	
}
