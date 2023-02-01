package com.service.userlogin.entity;

import java.util.Objects;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

@Entity
@Table(name="usuario")
public class UsuarioEntity {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="idUsuario")
	private long idUsuario;
	
	@Column(name="nomeUsuario")
	@NotBlank
	private String nomeUsuario;
	
	@Column(name="ufUsuario")
	@Size(min=2,max=2)
	@NotBlank
	private String ufUsuario;
	
	@Column(name="emailUsuario", unique=true)
	@Email
	@NotBlank
	private String emailUsuario;
	
	@Column(name="senhaUsuario")
	@NotBlank
	private String senhaUsuario;
	

	public long getIdUsuario() {
		return idUsuario;
	}

	public void setIdUsuario(long idUsuario) {
		this.idUsuario = idUsuario;
	}

	public String getNomeUsuario() {
		return nomeUsuario;
	}

	public void setNomeUsuario(String nomeUsuario) {
		this.nomeUsuario = nomeUsuario;
	}

	public String getUfUsuario() {
		return ufUsuario;
	}

	public void setUfUsuario(String ufUsuario) {
		this.ufUsuario = ufUsuario;
	}

	public String getEmailUsuario() {
		return emailUsuario;
	}

	public void setEmailUsuario(String emailUsuario) {
		this.emailUsuario = emailUsuario;
	}

	public String getSenhaUsuario() {
		return senhaUsuario;
	}

	public void setSenhaUsuario(String senhaUsuario) {
		this.senhaUsuario = senhaUsuario;
	}

	@Override
	public int hashCode() {
		return Objects.hash(emailUsuario, idUsuario, nomeUsuario, senhaUsuario, ufUsuario);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		UsuarioEntity other = (UsuarioEntity) obj;
		return Objects.equals(emailUsuario, other.emailUsuario) && idUsuario == other.idUsuario
				&& Objects.equals(nomeUsuario, other.nomeUsuario) && Objects.equals(senhaUsuario, other.senhaUsuario)
				&& Objects.equals(ufUsuario, other.ufUsuario);
	}

	@Override
	public String toString() {
		return "Usuario [Nome=" + nomeUsuario + ", UF=" + ufUsuario
				+ ", Email=" + emailUsuario + "]";
	}
	
}
