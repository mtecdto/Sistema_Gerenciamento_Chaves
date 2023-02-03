package com.service.accounts.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.service.accounts.entity.DepartamentoEntity;

@Repository
public interface DepartamentoRepository extends JpaRepository<DepartamentoEntity, Long>{

}
