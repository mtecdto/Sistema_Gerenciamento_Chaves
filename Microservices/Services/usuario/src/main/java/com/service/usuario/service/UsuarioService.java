package com.service.usuario.service;

import java.time.LocalTime;
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
		
		HttpStatus statuscodeResponse;
		StatusCodeJson statusCodeJson = new StatusCodeJson();
		
		try {
			
			usuarioRepository.save(usuarioEntity);
			statuscodeResponse = HttpStatus.CREATED;
			statusCodeJson.setStatuscode(statuscodeResponse);
			statusCodeJson.setMessage("Usuário "+usuarioEntity.getNomeUsuario()+" criado com sucesso");
			
		} catch (Exception e) {
			
			System.out.println("EXECAO: "+e);
			statuscodeResponse = HttpStatus.BAD_REQUEST;
			statusCodeJson.setStatuscode(statuscodeResponse);
			statusCodeJson.setMessage("Informações Inválidas");
			
		}
		
		return statusCodeJson;

	}
	
	public List<UsuarioEntity> getAllUsuarios(){
		
		return usuarioRepository.findAll();
		
	}
	
	public HttpStatus deleteByIdUsuario(Long idUsuario) {
		
		usuarioRepository.deleteById(idUsuario);
		
		return HttpStatus.OK;
		
	}
	
	public List<UsuarioEntity> searchByUserName(String nomeUsuario){
		
		return usuarioRepository.filtrarNomeUsuario(nomeUsuario);
		
	}
	
	public HttpStatus findUserToLogin(UserLoginObj userLogin) {
		
		HttpStatus statuscodeBDfindUser;
		
		UserLoginObj userRequest = userLogin;
		String emailRequest = userLogin.getEmailUser(); 
		UsuarioEntity userFromBD = usuarioRepository.findByEmailUsuario(emailRequest);
		
		if(userFromBD == null) {
			statuscodeBDfindUser = HttpStatus.NOT_FOUND;
		}else {
			
			String emailResponse = userFromBD.getEmailUsuario();
			String senhaResponse = userFromBD.getSenhaUsuario();
			
			UserLoginObj userDBResponse = new UserLoginObj(emailResponse, senhaResponse);
			
			if(userRequest.equals(userDBResponse)) {
				statuscodeBDfindUser = HttpStatus.OK;
			}else {
				statuscodeBDfindUser = HttpStatus.UNAUTHORIZED;
			}
			
		}

		return statuscodeBDfindUser;
		
	}
	
}
