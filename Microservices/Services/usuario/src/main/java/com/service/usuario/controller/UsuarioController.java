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
		
		if(usuario.isEmpty()) {
			statusCodeGetAllUserRequest = HttpStatus.NOT_FOUND;
		}else {
			statusCodeGetAllUserRequest = HttpStatus.OK;
		}
		
		return ResponseEntity.status(statusCodeGetAllUserRequest).body(usuario);
		
	}

	@DeleteMapping("/deletarusuario/{id}")
	public ResponseEntity<StatusCodeJson> deletarUsuario(@PathVariable("id") @Valid Long id){
		
		StatusCodeJson statusCodeJson = usuarioService.deleteByIdUsuario(id);
		
		return ResponseEntity.status(statusCodeJson.getStatuscode()).body(statusCodeJson);
		
	}
	
	@GetMapping("/filtrarusuario/{nomeusuario}")
	public ResponseEntity<StatusCodeJson> filtrarUsuarioNome(@PathVariable("nomeusuario") @Valid String nomeUser){
		
		StatusCodeJson statusCodeJson = new StatusCodeJson();
		
		String nomeUserToLowerCase = nomeUser.toLowerCase();
		
		List<UsuarioEntity> usuarios = usuarioService.searchByUserName(nomeUserToLowerCase);
		
		if(usuarios.isEmpty()) {
			statusCodeJson.setStatuscode(HttpStatus.NOT_FOUND);
			statusCodeJson.setMessage("No users found");
		}else {
			statusCodeJson.setStatuscode(HttpStatus.OK);
			statusCodeJson.setMessage(usuarios.toString());
		}
		
		return ResponseEntity.status(statusCodeJson.getStatuscode()).body(statusCodeJson);
		
	}
	
	@PostMapping("/loginrequest")
	public ResponseEntity<StatusCodeJson> loginRequest(@RequestBody UserLoginObj userLogin){
		
		StatusCodeJson statusCodeJson = usuarioService.findUserToLogin(userLogin);
		
		return ResponseEntity.status(statusCodeJson.getStatuscode()).body(statusCodeJson);
		
	}
	
}
