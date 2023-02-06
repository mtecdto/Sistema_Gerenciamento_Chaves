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

import com.service.accounts.entity.Nota;
import com.service.accounts.service.NotaService;

@RestController
@RequestMapping("/nota")
public class NotaController {

	@Autowired
	private NotaService notaService;
	
	@PostMapping("/saveNota")
	public ResponseEntity<Nota> saveNota(@RequestBody Nota nota) {
		
		nota = notaService.saveNota(nota);
		
		return ResponseEntity.status(HttpStatus.CREATED).body(nota); 
		
	}
	
	@GetMapping("/findAllNotas")
	public ResponseEntity<List<Nota>> findAllNotas(){
		
		List<Nota> notas = notaService.findAllNotas();
		
		return ResponseEntity.status(HttpStatus.OK).body(notas);
		
	}
	
	@DeleteMapping("/deleteNota/{id}")
	public ResponseEntity<Object> deleteNota(@PathVariable Long id) {
		
		notaService.deleteNota(id);
		
		return ResponseEntity.ok().build();
		
	}
	
}
