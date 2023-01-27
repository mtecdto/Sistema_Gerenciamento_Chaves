package com.service.usuario.exceptions.handler;

import java.util.Date;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.service.usuario.exceptions.ExceptionObjError;
import com.service.usuario.exceptions.NotFoundUserException;

@ControllerAdvice
public class CustomizedResponseEntityExceptionHandler extends ResponseEntityExceptionHandler{

	@ExceptionHandler(NotFoundUserException.class)
	public final ResponseEntity<Object> handleAllExceptions(Exception ex, WebRequest request){
		
		ExceptionObjError exceptionObjError = new ExceptionObjError(ex.getMessage(), request.getDescription(false), new Date());
		
		ResponseEntity<Object> entity = new ResponseEntity<>(exceptionObjError, HttpStatus.NOT_FOUND);
		
		return entity;
		
	}
	
}
