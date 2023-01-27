package com.service.usuario.entity;

import org.springframework.http.HttpStatus;

public class StatusCodeJson {

	private HttpStatus statuscode;
	private String message;

	public HttpStatus getStatuscode() {
		return statuscode;
	}

	public void setStatuscode(HttpStatus statuscode) {
		this.statuscode = statuscode;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	@Override
	public String toString() {
		return "StatusCodeJson [statuscode=" + statuscode + ", message=" + message + "]";
	}
	
}
