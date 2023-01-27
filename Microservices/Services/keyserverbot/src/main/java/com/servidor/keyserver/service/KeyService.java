package com.servidor.keyserver.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.servidor.keyserver.entity.KeyEntity;
import com.servidor.keyserver.repository.KeyRepository;

@Service
public class KeyService {

	@Autowired
	private KeyRepository keyRepository;
	
	public List<KeyEntity> findAllKeys(){
		
		return keyRepository.findAll();
		
	}
	
}
