package com.service.laboratorio.entity;

import java.util.Objects;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="laboratorio")
public class LaboratorioEntity {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long id_lab;
	
	@Column(name="uf_lab",unique=true)
	private String uf_lab;

	public long getId_lab() {
		return id_lab;
	}

	public void setId_lab(long id_lab) {
		this.id_lab = id_lab;
	}

	public String getUf_lab() {
		return uf_lab;
	}

	public void setUf_lab(String uf_lab) {
		this.uf_lab = uf_lab;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id_lab, uf_lab);
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
		return id_lab == other.id_lab && Objects.equals(uf_lab, other.uf_lab);
	}
	
}
