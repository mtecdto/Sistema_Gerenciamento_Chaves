package com.service.accounts.entity;

import java.util.Objects;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

@Entity
@Table(name="laboratorio")
public class LaboratorioEntity {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_lab")
	private Long id;
	
	@Column(name="uf")
	@NotBlank
	@Size(min=2,max=2)
	private String uf;
	
	@Column(name="codigo")
	@NotNull
	private int codigo;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getUf() {
		return uf;
	}

	public void setUf(String uf) {
		this.uf = uf;
	}

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	@Override
	public int hashCode() {
		return Objects.hash(codigo, id, uf);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		LaboratorioEntity other = (LaboratorioEntity) obj;
		return codigo == other.codigo && Objects.equals(id, other.id) && Objects.equals(uf, other.uf);
	}
	
}
