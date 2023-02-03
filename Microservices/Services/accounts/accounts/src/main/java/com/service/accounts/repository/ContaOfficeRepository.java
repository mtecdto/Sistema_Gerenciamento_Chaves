package com.service.accounts.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.service.accounts.entity.ContaOfficeEntity;

@Repository
public interface ContaOfficeRepository extends JpaRepository<ContaOfficeEntity, Long>{

	
	
}
