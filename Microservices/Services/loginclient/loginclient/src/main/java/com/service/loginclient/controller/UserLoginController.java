package com.service.loginclient.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.service.loginclient.model.UserLogin;
import com.service.loginclient.service.LoginService;

@RestController
@RequestMapping("/login")
public class UserLoginController {

	@Autowired
	private LoginService loginService;
	
	@PostMapping("/loginrequest")
	public ResponseEntity<HttpStatus> loginRequest(@RequestBody UserLogin userLogin){
		
		boolean loginResponse = loginService.loginProcess(userLogin);
		
		HttpStatus statuscodeResponse;
		
		if(loginResponse == true) {
			
			statuscodeResponse = HttpStatus.OK;
			
		}else {
			
			statuscodeResponse = HttpStatus.UNAUTHORIZED;
			
		}
		
		return ResponseEntity.status(statuscodeResponse).body(statuscodeResponse);
		
	}
	
}
