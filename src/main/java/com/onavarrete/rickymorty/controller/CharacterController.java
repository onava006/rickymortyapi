package com.onavarrete.rickymorty.controller;


import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.onavarrete.rickymorty.model.Entity;
import com.onavarrete.rickymorty.service.CharacterProfileService;

@RestController
@RequestMapping("character")
public class CharacterController {

	CharacterProfileService service;
	
	
	public CharacterController(CharacterProfileService service) {
		this.service = service;
	}

	@GetMapping("/{characterId}")
	ResponseEntity<Entity> getChracter(@PathVariable Integer characterId) {

	
		return service.genCharacterProfileById(characterId);
	}

}
