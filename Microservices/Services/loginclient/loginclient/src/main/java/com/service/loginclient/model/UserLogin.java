package com.service.loginclient.model;

import java.util.Objects;

public class UserLogin {

	private String emailUser;
	private String senhaUser;
	
	public UserLogin(String emailUser, String senhaUser) {
		this.emailUser = emailUser;
		this.senhaUser = senhaUser;
	}
	
	public String getEmailUser() {
		return emailUser;
	}
	public void setEmailUser(String emailUser) {
		this.emailUser = emailUser;
	}
	public String getSenhaUser() {
		return senhaUser;
	}
	public void setSenhaUser(String senhaUser) {
		this.senhaUser = senhaUser;
	}
	@Override
	public int hashCode() {
		return Objects.hash(emailUser, senhaUser);
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		UserLogin other = (UserLogin) obj;
		return Objects.equals(emailUser, other.emailUser) && Objects.equals(senhaUser, other.senhaUser);
	}
	
}
