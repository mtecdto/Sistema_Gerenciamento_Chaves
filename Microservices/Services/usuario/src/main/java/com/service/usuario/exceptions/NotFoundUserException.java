package com.service.usuario.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class NotFoundUserException extends RuntimeException{

	private static final long serialVersionUID = 1L;

	public NotFoundUserException(String exception) {
		
		super(exception);
		
	}
	
}
