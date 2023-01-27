package com.service.laboratorio.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.service.laboratorio.entity.LaboratorioEntity;
import com.service.laboratorio.repository.LaboratorioRepository;

@Service
public class LaboratorioService {

	@Autowired
	private LaboratorioRepository laboratorioRepository;
	
	public LaboratorioEntity saveLaboratorio(LaboratorioEntity lab) {
	
		return laboratorioRepository.save(lab);

	}
	
	public List<LaboratorioEntity> findAllLaboratorio(){
		
		return laboratorioRepository.findAll();
		
	}
	
	public HttpStatus deleteByIdLaboratorio(Long id) {
		
		laboratorioRepository.deleteById(id);
		
		return HttpStatus.OK;
		
	}
	
}
