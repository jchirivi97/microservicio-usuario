package edu.escuelaing.arep.usuarios.services.impl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.escuelaing.arep.usuarios.model.usuario;
import edu.escuelaing.arep.usuarios.recovery.usuarioRepository;
import edu.escuelaing.arep.usuarios.services.usuarioServices;

@Service
public class usuarioServicesImpl implements usuarioServices {

	
	@Autowired
	usuarioRepository usuarioRepo;

	@Override
	public usuario getUser(String nickname) {
		Optional<usuario> user = usuarioRepo.findById(nickname);
		return user.get();
	}

	@Override
	public void saveUser(usuario user) {
		usuarioRepo.save(user);		
	}
	
	@Override
	public usuario login(String nickname, String password) {
		usuario user = usuarioRepo.getLogin(nickname, password);
		return user;
	}

	
}
