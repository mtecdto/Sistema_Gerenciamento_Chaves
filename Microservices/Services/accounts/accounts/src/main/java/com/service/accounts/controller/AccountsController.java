package com.service.accounts.controller;

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

import com.service.accounts.entity.LaboratorioEntity;
import com.service.accounts.service.LaboratorioService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/accounts")
public class AccountsController {
	
	@Autowired
	private LaboratorioService laboratorioService;

	@GetMapping("/getAllLabs")
	public ResponseEntity<List<LaboratorioEntity>> getAllLabs(){
		
		HttpStatus statuscode = HttpStatus.OK;
		
		List<LaboratorioEntity> labs = laboratorioService.findAllLabs();
		
		if(labs.isEmpty()) {
			statuscode = HttpStatus.NOT_FOUND;
		}
		
		return ResponseEntity.status(statuscode).body(labs);
		
	}
	
	@PostMapping("/saveLab")
	public ResponseEntity<LaboratorioEntity> saveLabRequest(@RequestBody @Valid LaboratorioEntity lab){
		
		lab = laboratorioService.saveLab(lab);
		
		return ResponseEntity.status(HttpStatus.OK).body(lab);
		
	}
	
	@DeleteMapping("/deleteLab/{id}")
	public ResponseEntity<HttpStatus> deleteLab(@PathVariable("id") Long id) {
		
		HttpStatus statuscode = laboratorioService.deleteLab(id);
		
		return ResponseEntity.status(statuscode).build();
		
	}

}
