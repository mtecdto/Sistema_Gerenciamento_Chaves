package com.service.usuario.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
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

		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
		
		String nameUsuario = usuarioEntity.getNomeUsuario();
		usuarioEntity.setNomeUsuario(nameUsuario.toLowerCase());
		
		String passwordRequest = usuarioEntity.getSenhaUsuario();
		String passwordEncoded = encoder.encode(passwordRequest);
		usuarioEntity.setSenhaUsuario(passwordEncoded);
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
		
		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
		StatusCodeJson statusCodeJson = new StatusCodeJson();
		
		String emailRequest = userLogin.getEmailUser();
		
		UsuarioEntity userFromBD = usuarioRepository.findByEmailUsuario(emailRequest);
		
		if(userFromBD == null) {
			statusCodeJson.setStatuscode(HttpStatus.NOT_FOUND);
			statusCodeJson.setMessage("This account does not exist");
		}else {
			
			String senhaRaw = userLogin.getSenhaUser();
			String senhaEncoded = userFromBD.getPassword();
			
			if(encoder.matches(senhaRaw, senhaEncoded)) {
				statusCodeJson.setStatuscode(HttpStatus.OK);
				statusCodeJson.setMessage("Login Sucessfull");
				statusCodeJson.setToken(senhaEncoded);
			}else {
				statusCodeJson.setStatuscode(HttpStatus.UNAUTHORIZED);
				statusCodeJson.setMessage("Incorrect Password");
			}
			
		}

		return statusCodeJson;
		
	}
	
}
