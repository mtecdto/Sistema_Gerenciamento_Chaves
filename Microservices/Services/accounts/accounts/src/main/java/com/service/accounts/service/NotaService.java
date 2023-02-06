package com.service.accounts.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.service.accounts.entity.Nota;
import com.service.accounts.repository.NotaRepository;

@Service
public class NotaService {

	@Autowired
	private NotaRepository notaRepository;
	
	public Nota saveNota(Nota nota) {
		
		return notaRepository.save(nota);
		
	}
	
	public List<Nota> findAllNotas(){
		
		return notaRepository.findAll();
		
	}
	
	public void deleteNota(Long id) {
		
		if(notaRepository.existsById(id)) {
			
			notaRepository.deleteById(id);
			
		}
		
	}
	
}
