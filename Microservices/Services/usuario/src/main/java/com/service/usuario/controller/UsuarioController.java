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

import com.service.usuario.entity.StatusCodeJson;
import com.service.usuario.entity.UserLoginObj;
import com.service.usuario.entity.UsuarioEntity;
import com.service.usuario.service.UsuarioService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/usuario")
public class UsuarioController {

	@Autowired
	private UsuarioService usuarioService;
	
	@PostMapping("/inserirusuario")
	public ResponseEntity<StatusCodeJson> inserirUsuario(@RequestBody @Valid UsuarioEntity usuarioEntity){
		
		StatusCodeJson statusCodeJson = usuarioService.saveUsuario(usuarioEntity);
		
		return ResponseEntity.status(statusCodeJson.getStatuscode()).body(statusCodeJson);
		
	}
	
	@GetMapping("/getallusuarios")
	public ResponseEntity<List<UsuarioEntity>> getAllUsuarios(){
		
		HttpStatus statusCodeGetAllUserRequest;
		
		List<UsuarioEntity> usuario = usuarioService.getAllUsuarios();
		
		if(usuario == null) {
			statusCodeGetAllUserRequest = HttpStatus.NOT_FOUND;
		}else {
			statusCodeGetAllUserRequest = HttpStatus.OK;
		}
		
		return ResponseEntity.status(statusCodeGetAllUserRequest).body(usuario);
		
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
		
		return ResponseEntity.ok().body(usuario);
		
	}
	
	@PostMapping("/loginrequest")
	public ResponseEntity<HttpStatus> loginRequest(@RequestBody UserLoginObj userLogin){
		
		HttpStatus loginResponseStatusCode = usuarioService.findUserToLogin(userLogin);
		
		return ResponseEntity.status(loginResponseStatusCode).body(loginResponseStatusCode);
		
	}
	
}
