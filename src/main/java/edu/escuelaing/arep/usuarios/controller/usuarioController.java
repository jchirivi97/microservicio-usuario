package edu.escuelaing.arep.usuarios.controller;

import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import edu.escuelaing.arep.usuarios.model.usuario;
import edu.escuelaing.arep.usuarios.services.usuarioServices;
import org.springframework.http.HttpStatus;

@RestController
@RequestMapping(value="/usuario")
public class usuarioController {

	@Autowired
	usuarioServices usuarioServ;
	
	@RequestMapping(method = RequestMethod.POST)
	public void saveUser(usuario user){
		usuarioServ.saveUser(user);
	}
	
	@RequestMapping(method = RequestMethod.GET,path="/{nickname}")
	public ResponseEntity<?> getUser(@PathVariable("nickname") String nickname){	
		usuario user = usuarioServ.getUser(nickname);
                String data = new Gson().toJson(user);

                return new ResponseEntity<>(data, HttpStatus.ACCEPTED);
	}
	
	@RequestMapping(method = RequestMethod.GET,path="/{nickname}/{password}")
	public ResponseEntity<?> getUser(@PathVariable("nickname") String nickname,@PathVariable("password") String password){
		usuario user = usuarioServ.login(nickname, password);
                
                String data = new Gson().toJson(user);

                return new ResponseEntity<>(data, HttpStatus.ACCEPTED);
	}
}
