package com.service.departamento.repository;

import org.springframework.stereotype.Repository;

import com.service.departamento.entity.DepartamentoEntity;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;

@Repository
public class DepartamentoTypedQuery {

	@PersistenceContext
	private EntityManager entityManager;
	
	
	public DepartamentoEntity customDepartamentoByName(String nome) {
		
		String query = "SELECT d FROM DepartamentoEntity d WHERE d.nome = :nome";
		TypedQuery<DepartamentoEntity> typedQuery = entityManager.createQuery(query,DepartamentoEntity.class);
		typedQuery.setParameter("nome", nome);
		return typedQuery.getSingleResult();
		
	}
}
