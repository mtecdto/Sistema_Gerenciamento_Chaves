package com.service.laboratorio.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.service.laboratorio.entity.LaboratorioEntity;

public interface LaboratorioRepository extends JpaRepository<LaboratorioEntity, Long>{

}
