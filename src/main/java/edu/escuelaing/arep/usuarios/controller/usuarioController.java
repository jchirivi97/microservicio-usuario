package edu.escuelaing.arep.usuarios.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import edu.escuelaing.arep.usuarios.model.Cancion;
import edu.escuelaing.arep.usuarios.model.ListaReproduccion;
import edu.escuelaing.arep.usuarios.model.usuario;
import edu.escuelaing.arep.usuarios.services.usuarioServices;

@RestController
@RequestMapping(value="/usuario")
public class usuarioController {
	
	private RestTemplate rest;

	@Autowired
	usuarioServices usuarioServ;
	
	@RequestMapping(method = RequestMethod.POST)
	public void saveUser(usuario user){
		usuarioServ.saveUser(user);
	}
	
	@RequestMapping(method = RequestMethod.GET,path="/{nickname}")
	public ResponseEntity<usuario> getUser(@PathVariable("nickname") String nickname){
		usuario user = usuarioServ.getUser(nickname);
		return ResponseEntity.ok(user);
	}
	
	@RequestMapping(method = RequestMethod.GET,path="/{nickname}/{password}")
	public ResponseEntity<usuario> getUser(@PathVariable("nickname") String nickname,@PathVariable("password") String password){
		usuario user = usuarioServ.login(nickname, password);
		return ResponseEntity.ok(user);
	}
	
	
	@RequestMapping(method = RequestMethod.GET,path="/listReproduccion/{nickname}")
	public ResponseEntity<List<ListaReproduccion>> getListReproducion(@PathVariable("nickname") String user){
		List<ListaReproduccion> list = usuarioServ.listasReproduccion(user);
		return ResponseEntity.ok(list);
	}
	
	@RequestMapping(method = RequestMethod.GET,path="/listCanciones/{nickname}/{nombre}")
	public ResponseEntity<List<Cancion>> getListCanciones(@PathVariable("nickname") String user,@PathVariable("nombre") String nombre){
		List<Cancion> list = usuarioServ.listasCanciones(user,nombre);
		return ResponseEntity.ok(list);
	}
	
}
