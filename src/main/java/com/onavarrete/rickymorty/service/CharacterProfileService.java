package com.onavarrete.rickymorty.service;


import org.springframework.http.ResponseEntity;

import com.onavarrete.rickymorty.model.Entity;


 

public interface CharacterProfileService {
	
	
	ResponseEntity<Entity> genCharacterProfileById(Integer id);

	
	
}

