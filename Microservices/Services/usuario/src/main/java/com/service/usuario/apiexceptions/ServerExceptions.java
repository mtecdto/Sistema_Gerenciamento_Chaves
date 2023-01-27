package com.service.usuario.apiexceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import jakarta.persistence.EntityNotFoundException;

@RestControllerAdvice
public class ServerExceptions {

	@ExceptionHandler(EntityNotFoundException.class)
    public ResponseEntity<HttpStatus> notFoundExceptionRequest(){
        return ResponseEntity.notFound().build();
    }
	
}
