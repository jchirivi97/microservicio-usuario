package edu.escuelaing.arep.usuarios.services.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import edu.escuelaing.arep.usuarios.model.Cancion;
import edu.escuelaing.arep.usuarios.model.ListaReproduccion;
import edu.escuelaing.arep.usuarios.model.usuario;
import edu.escuelaing.arep.usuarios.recovery.usuarioRepository;
import edu.escuelaing.arep.usuarios.services.usuarioServices;

@Service
public class usuarioServicesImpl implements usuarioServices {

	@Autowired
	private RestTemplate rest;
	
	
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
	public List<ListaReproduccion> listasReproduccion(String nickname) {
		
		ResponseEntity<List<ListaReproduccion>> listRes = rest.exchange("http://cancion-api/lista/user/"+nickname,HttpMethod.GET,null,
				new ParameterizedTypeReference<List<ListaReproduccion>>() {
        });
		
		List<ListaReproduccion> list = listRes.getBody();
		
		return list;
	}

	@Override
	public List<Cancion> listasCanciones(String nickname,String nombre) {
		ResponseEntity<List<Cancion>> listRes = rest.exchange("http://cancion-api/lista/canciones/"+nickname+"/"+nombre,HttpMethod.GET,null,
				new ParameterizedTypeReference<List<Cancion>>() {
        });
		
		List<Cancion> list = listRes.getBody();
		
		return list;
	}

	@Override
	public usuario login(String nickname, String password) {
		usuario user = usuarioRepo.getLogin(nickname, password);
		return user;
	}

	
}
