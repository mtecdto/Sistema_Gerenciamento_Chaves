package com.service.accounts.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.service.accounts.entity.LaboratorioEntity;

@Repository
public interface LaboratorioRepository extends JpaRepository<LaboratorioEntity, Long>{

	
	
}
