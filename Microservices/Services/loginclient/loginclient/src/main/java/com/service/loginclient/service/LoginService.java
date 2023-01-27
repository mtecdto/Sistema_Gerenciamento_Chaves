package com.service.loginclient.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.service.loginclient.model.UserLogin;

@Service
public class LoginService {

	@Autowired
	private UserRequest userRequest;
	
	public boolean loginProcess(UserLogin userLoginRequest) {
		
		String emailPassed = userLoginRequest.getEmailUser();
		
		UserLogin userLoginResponse = userRequest.consumingUserEntity(emailPassed);
		
		boolean processResponse;
		
		if(userLoginRequest.equals(userLoginResponse)) {
			
			processResponse = true;
				
		}else {
			
			processResponse = false;
			
		}
		
		return processResponse;
		
	}
	
}
