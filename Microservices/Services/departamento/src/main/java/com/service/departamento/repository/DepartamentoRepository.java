package com.service.departamento.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.service.departamento.entity.DepartamentoEntity;

public interface DepartamentoRepository extends JpaRepository<DepartamentoEntity, Long>{

	DepartamentoEntity findByNome(String nome);
	
	@Query("SELECT d FROM DepartamentoEntity d WHERE d.nome = :nome")
	DepartamentoEntity buscarPorNomeDepartamento(@Param("nome") String nomeDepart);
	
}
