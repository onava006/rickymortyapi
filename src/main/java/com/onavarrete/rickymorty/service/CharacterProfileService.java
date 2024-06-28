package com.onavarrete.rickymorty.service;

import java.util.Optional;

import org.springframework.http.ResponseEntity;

import com.onavarrete.rickymorty.model.Entity;
import com.onavarrete.rickymorty.model.entity.CharacterEntity;

 

public interface CharacterProfileService {
	
	
	ResponseEntity<Entity> getCharacterDataById(Integer id);

	
	
}

