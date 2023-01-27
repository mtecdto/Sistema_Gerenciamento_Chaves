package com.servidor.keyserver.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.servidor.keyserver.entity.KeyEntity;
import com.servidor.keyserver.service.KeyService;

@RestController
@RequestMapping("/keyserver")
public class KeyController {

	@Autowired
	private KeyService keyService;
	
	@GetMapping("/getallkeys")
	public ResponseEntity<List<KeyEntity>> getAllKeys(){
		
		return ResponseEntity.ok().body(keyService.findAllKeys());
		
	}
	
}
