package edu.escuelaing.arep.usuarios.recovery;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import edu.escuelaing.arep.usuarios.model.usuario;

public interface usuarioRepository extends JpaRepository<usuario,String> {
	
	@Query(value="select u.nickname as nickname,u.password as password,u.nombre as nombre from  usuario u where u.nickname= :nickname and u.password= :password",nativeQuery = true)
	usuario getLogin(String nickname,String password);

}
