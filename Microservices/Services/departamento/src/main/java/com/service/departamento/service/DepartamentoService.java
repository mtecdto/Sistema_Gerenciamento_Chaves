package com.service.departamento.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.service.departamento.entity.DepartamentoEntity;
import com.service.departamento.repository.DepartamentoRepository;

@Service
public class DepartamentoService {

	@Autowired
	private DepartamentoRepository departamentoRepository;
	
	public DepartamentoEntity saveDepartamento(DepartamentoEntity departamento) {
		
		return departamentoRepository.save(departamento);
		
	}
	
	public List<DepartamentoEntity> findAllDepartamentos(){
		
		return departamentoRepository.findAll();
		
	}
	
	public HttpStatus deleteByIdDepartamento(Long id) {
		
		departamentoRepository.deleteById(id);
		
		return HttpStatus.OK;
		
	}
	
	public Long countDepartamentos() {
		
		return departamentoRepository.count();
		
	}
	
}
