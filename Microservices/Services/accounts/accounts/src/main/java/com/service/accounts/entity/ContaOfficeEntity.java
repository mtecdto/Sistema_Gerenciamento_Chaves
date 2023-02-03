package com.service.accounts.entity;

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
@Table(name="contaoffice")
public class ContaOfficeEntity {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_contaoffice")
	private Long id;
	
	@Column(name="emailUsuario", unique=true)
	@Email
	@NotBlank
	private String emailUsuario;
	
	@Column(name="senha")
	@Size(min=1,max=30)
	private String senha;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getEmailUsuario() {
		return emailUsuario;
	}

	public void setEmailUsuario(String emailUsuario) {
		this.emailUsuario = emailUsuario;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	@Override
	public int hashCode() {
		return Objects.hash(emailUsuario, id, senha);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ContaOfficeEntity other = (ContaOfficeEntity) obj;
		return Objects.equals(emailUsuario, other.emailUsuario) && Objects.equals(id, other.id)
				&& Objects.equals(senha, other.senha);
	}
	
}
