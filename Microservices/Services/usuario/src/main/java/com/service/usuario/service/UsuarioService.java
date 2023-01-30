package com.service.usuario.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.service.usuario.entity.StatusCodeJson;
import com.service.usuario.entity.UserLoginObj;
import com.service.usuario.entity.UsuarioEntity;
import com.service.usuario.repository.UsuarioRepository;

@Service
public class UsuarioService {

	@Autowired
	private UsuarioRepository usuarioRepository;
	
	public StatusCodeJson saveUsuario(UsuarioEntity usuarioEntity) {

		String nameUsuario = usuarioEntity.getNomeUsuario();
		usuarioEntity.setNomeUsuario(nameUsuario.toLowerCase());
		
		StatusCodeJson statusCodeJson = new StatusCodeJson();
		
		try {
			
			usuarioRepository.save(usuarioEntity);
			statusCodeJson.setStatuscode(HttpStatus.CREATED);
			statusCodeJson.setMessage(usuarioEntity.toString());
			
		} catch (Exception e) {
			
			statusCodeJson.setStatuscode(HttpStatus.BAD_REQUEST);
			statusCodeJson.setMessage("Invalid information");
			
		}
		
		return statusCodeJson;

	}
	
	public List<UsuarioEntity> getAllUsuarios(){
		
		return usuarioRepository.findAll();
		
	}
	
	public StatusCodeJson deleteByIdUsuario(Long idUsuario) {
		
		StatusCodeJson statusCodeJson = new StatusCodeJson();
		
		try {
			
			usuarioRepository.deleteById(idUsuario);
			statusCodeJson.setStatuscode(HttpStatus.OK);
			statusCodeJson.setMessage("Deleted user");
			
		} catch (Exception e) {
			
			statusCodeJson.setStatuscode(HttpStatus.BAD_REQUEST);
			statusCodeJson.setMessage("Error deleting");
			
		}
		
		
		return statusCodeJson;
		
	}
	
	public List<UsuarioEntity> searchByUserName(String nomeUsuario){
		
		return usuarioRepository.filtrarNomeUsuario(nomeUsuario);
		
	}
	
	public StatusCodeJson findUserToLogin(UserLoginObj userLogin) {
		
		StatusCodeJson statusCodeJson = new StatusCodeJson();
		
		UserLoginObj userRequest = userLogin;
		String emailRequest = userLogin.getEmailUser(); 
		UsuarioEntity userFromBD = usuarioRepository.findByEmailUsuario(emailRequest);
		
		if(userFromBD == null) {
			statusCodeJson.setStatuscode(HttpStatus.NOT_FOUND);
			statusCodeJson.setMessage("This account does not exist");
		}else {
			
			String emailResponse = userFromBD.getEmailUsuario();
			String senhaResponse = userFromBD.getSenhaUsuario();
			
			UserLoginObj userDBResponse = new UserLoginObj(emailResponse, senhaResponse);
			
			if(userRequest.equals(userDBResponse)) {
				statusCodeJson.setStatuscode(HttpStatus.OK);
				statusCodeJson.setMessage("Login Sucessfull");
			}else {
				statusCodeJson.setStatuscode(HttpStatus.UNAUTHORIZED);
				statusCodeJson.setMessage("Incorrect Password");
			}
			
		}

		return statusCodeJson;
		
	}
	
}
