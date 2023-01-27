package com.service.departamento.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.service.departamento.entity.DepartamentoEntity;
import com.service.departamento.service.DepartamentoService;

@RestController
@RequestMapping("/departamento")
public class DepartamentoController {

	@Autowired
	private DepartamentoService departamentoService;
	
	@PostMapping(path="/insertdepartamento")
	public ResponseEntity<DepartamentoEntity> insertDepartamento(@RequestBody DepartamentoEntity departamento){
		
		departamento = departamentoService.saveDepartamento(departamento);
		
		return new ResponseEntity<DepartamentoEntity>(departamento,HttpStatus.CREATED);
		
	}
	
	@GetMapping("/getalldepartamentos")
	public ResponseEntity<List<DepartamentoEntity>> getalldepartamentos(){
		
		return ResponseEntity.ok().body(departamentoService.findAllDepartamentos());
		
	}
	
	@DeleteMapping("/deletedepartamento/{id}")
	public ResponseEntity<HttpStatus> deleteDepartamento(@PathVariable("id") Long id){
		
		return ResponseEntity.ok(departamentoService.deleteByIdDepartamento(id));
		
	}

	@GetMapping("/countdepartamento")
	public ResponseEntity<Long> getCountDepartamento(){
		
		return ResponseEntity.ok().body(departamentoService.countDepartamentos());
		
	}
	
}

