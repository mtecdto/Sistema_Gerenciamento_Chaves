package com.service.departamento.entity;

import java.util.Objects;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="departamento")
public class DepartamentoEntity {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id_departamento;
	
	@Column(name="nome_departamento",unique=true)
	private String nome;

	public Long getId_departamento() {
		return id_departamento;
	}

	public void setId_departamento(Long id_departamento) {
		this.id_departamento = id_departamento;
	}

	public String getNome_departamento() {
		return nome;
	}

	public void setNome_departamento(String nome_departamento) {
		this.nome = nome_departamento;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id_departamento, nome);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		DepartamentoEntity other = (DepartamentoEntity) obj;
		return Objects.equals(id_departamento, other.id_departamento)
				&& Objects.equals(nome, other.nome);
	}
	
}
