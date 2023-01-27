package com.service.loginclient.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.service.loginclient.feigninterface.UserClientInterface;
import com.service.loginclient.model.UserLogin;

@Service
public class UserRequest {

	@Autowired
	private UserClientInterface userClientInterface;
	
	public UserLogin consumingUserEntity(String emailUser) {
		
		//UserLogin usuarioAuxiliar = new UserLogin(emailUser, "pid4002");
		
		UserLogin usuarioAuxiliar = userClientInterface.userRequestLogin(emailUser);
		
		return usuarioAuxiliar;
		
	}
	
}
