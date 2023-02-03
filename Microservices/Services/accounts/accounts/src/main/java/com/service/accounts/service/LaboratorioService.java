package com.service.accounts.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.service.accounts.entity.LaboratorioEntity;
import com.service.accounts.repository.LaboratorioRepository;

@Service
public class LaboratorioService {

	@Autowired
	private LaboratorioRepository laboratorioRepository;
	
	public List<LaboratorioEntity> findAllLabs(){
		
		return laboratorioRepository.findAll();
		
	}
	
	public LaboratorioEntity saveLab(LaboratorioEntity labRequest) {
		
		return laboratorioRepository.save(labRequest);
		
	}
	
	public HttpStatus deleteLab(Long id) {
		
		HttpStatus statuscode;
		
		try {
			laboratorioRepository.deleteById(id);
			statuscode = HttpStatus.OK;
		} catch (Exception e) {
			statuscode = HttpStatus.BAD_REQUEST;
		}
		
		return statuscode;

	}
	
}
