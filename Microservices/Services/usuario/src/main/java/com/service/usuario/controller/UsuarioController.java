package com.service.usuario.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.service.usuario.entity.UserLoginObj;
import com.service.usuario.entity.UsuarioEntity;
import com.service.usuario.exceptions.NotFoundUserException;
import com.service.usuario.service.UsuarioService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/usuario")
public class UsuarioController {

	@Autowired
	private UsuarioService usuarioService;
	
	@PostMapping("/inserirusuario")
	public ResponseEntity<UsuarioEntity> inserirUsuario(@RequestBody @Valid UsuarioEntity usuarioEntity){
		
		UsuarioEntity usuario = usuarioService.saveUsuario(usuarioEntity);
		
		return ResponseEntity.ok().body(usuario);
		
	}
	
	@GetMapping("/getallusuarios")
	public ResponseEntity<List<UsuarioEntity>> getAllUsuarios(){
		
		List<UsuarioEntity> usuario = usuarioService.getAllUsuarios();
		
		if(usuario.isEmpty()) {
			throw new NotFoundUserException("Not Found");
		}
		
		return ResponseEntity.ok().body(usuario);
		
	}

	@DeleteMapping("/deletarusuario/{id}")
	public ResponseEntity<HttpStatus> deletarUsuario(@PathVariable("id") @Valid Long id){
		
		try {
			
			usuarioService.deleteByIdUsuario(id);
			return ResponseEntity.ok().build();
			
		} catch (Exception e) {
			
			return ResponseEntity.notFound().build();
			
		}
		
	}
	
	@GetMapping("/filtrarusuario/{nomeusuario}")
	public ResponseEntity<List<UsuarioEntity>> filtrarUsuarioNome(@PathVariable("nomeusuario") @Valid String nomeUser){
		
		List<UsuarioEntity> usuario = usuarioService.searchByUserName(nomeUser);
		
		if(usuario.isEmpty()) {
			throw new NotFoundUserException("Not Found");
		}
		
		return ResponseEntity.ok().body(usuario);
		
	}
	
	@GetMapping("/getusertologin/{emailtologin}")
	public ResponseEntity<UserLoginObj> getUserToLogin(@PathVariable("emailtologin") @Valid String emailtologin){

		UserLoginObj usuarioToLogin = usuarioService.findUserToLogin(emailtologin);
		
		if(usuarioToLogin == null) {
			throw new NotFoundUserException("Not Found");
		}
		
		return ResponseEntity.ok().body(usuarioToLogin);
		
	}
	
}
