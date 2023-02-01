package com.service.userlogin.entity;

import org.springframework.http.HttpStatus;

public class StatusCodeJson {

	private HttpStatus statuscode;
	private String message;
	private String token;

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

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	@Override
	public String toString() {
		return "StatusCodeJson [statuscode=" + statuscode + ", message=" + message + ", token=" + token + "]";
	}
	
}
