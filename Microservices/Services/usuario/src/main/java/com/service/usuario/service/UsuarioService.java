package com.service.usuario.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.service.usuario.entity.UserLoginObj;
import com.service.usuario.entity.UsuarioEntity;
import com.service.usuario.repository.UsuarioRepository;

@Service
public class UsuarioService {

	@Autowired
	private UsuarioRepository usuarioRepository;
	
	public UsuarioEntity saveUsuario(UsuarioEntity usuarioEntity) {
		
		return usuarioRepository.save(usuarioEntity);

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
	
	public UserLoginObj findUserToLogin(String email) {
		
		UsuarioEntity userFromBD = usuarioRepository.findByEmailUsuario(email);
		String emailResponse = userFromBD.getEmailUsuario();
		String senhaResponse = userFromBD.getSenhaUsuario();
		
		UserLoginObj userDB = new UserLoginObj(emailResponse, senhaResponse);
		
		return userDB;
		
	}
	
}
