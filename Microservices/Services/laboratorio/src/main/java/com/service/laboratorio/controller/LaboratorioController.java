package com.service.laboratorio.controller;

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

import com.service.laboratorio.entity.LaboratorioEntity;
import com.service.laboratorio.service.LaboratorioService;

@RestController
@RequestMapping("/laboratorio")
public class LaboratorioController {
	
	@Autowired
	private LaboratorioService laboratorioService;
	
	@PostMapping("/insertlab")
	public ResponseEntity<LaboratorioEntity> insertLaboratorio(@RequestBody LaboratorioEntity lab) {
		
		return ResponseEntity.ok(laboratorioService.saveLaboratorio(lab));
		
	}
	
	@GetMapping("/getalllabs")
	public ResponseEntity<List<LaboratorioEntity>> getAllLaboratorio(){
		
		return ResponseEntity.ok().body(laboratorioService.findAllLaboratorio());
		
	}
	
	@DeleteMapping("/deletelab/{id}")
	public ResponseEntity<HttpStatus> deleteLaboratorio(@PathVariable("id") Long id){
		
		return ResponseEntity.ok(laboratorioService.deleteByIdLaboratorio(id));
		
	}
	
}
