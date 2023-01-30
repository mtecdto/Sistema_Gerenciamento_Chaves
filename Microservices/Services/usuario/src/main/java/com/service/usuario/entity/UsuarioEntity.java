package com.service.usuario.entity;

import java.util.Collection;
import java.util.List;
import java.util.Objects;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

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
public class UsuarioEntity implements UserDetails{

	private static final long serialVersionUID = 1L;

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

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {

		return List.of(new SimpleGrantedAuthority("ROLE_USER"));
		
	}

	@Override
	public String getPassword() {

		return senhaUsuario;
		
	}

	@Override
	public String getUsername() {
		
		return emailUsuario;
		
	}

	@Override
	public boolean isAccountNonExpired() {
		
		return true;
		
	}

	@Override
	public boolean isAccountNonLocked() {
		
		return true;
		
	}

	@Override
	public boolean isCredentialsNonExpired() {
		
		return true;
		
	}

	@Override
	public boolean isEnabled() {
		
		return true;
		
	}
	
}
