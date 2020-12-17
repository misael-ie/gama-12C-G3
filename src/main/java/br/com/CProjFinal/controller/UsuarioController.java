package br.com.CProjFinal.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.CProjFinal.beans.Usuario;
import br.com.CProjFinal.dao.UsuarioDAO;


@RestController
@CrossOrigin("*")
public class UsuarioController {
	@Autowired
	private UsuarioDAO dao;
	
	
	@PostMapping("/login_email")
	public ResponseEntity<Usuario> logar_email(@RequestBody Usuario objeto) {
		Usuario response = dao.findByEmailAndSenha(objeto.getEmail(), objeto.getSenha());
		if (response == null) {
			return ResponseEntity.status(403).build();
		}
		return ResponseEntity.ok(response);
		
	}	
	
	@PostMapping("/login_racf")
	public ResponseEntity<Usuario> logar_racf(@RequestBody Usuario objeto) {
		Usuario response = dao.findByRacfAndSenha(objeto.getRacf(), objeto.getSenha());
		if (response == null) {
			return ResponseEntity.status(403).build();
		}
		return ResponseEntity.ok(response);
		
	}

}
