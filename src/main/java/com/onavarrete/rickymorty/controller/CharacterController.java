package com.onavarrete.rickymorty.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.onavarrete.rickymorty.model.Entity;
import com.onavarrete.rickymorty.model.entity.ErrorEntity;
import com.onavarrete.rickymorty.service.CharacterProfileService;

@RestController
@RequestMapping("character")
public class CharacterController {

	CharacterProfileService service;

	public CharacterController(@Autowired CharacterProfileService service) {
		this.service = service;
	}

	@GetMapping("/{characterId}")
	ResponseEntity<Entity> getChracter(@PathVariable Integer characterId) {

	
		return service.getCharacterDataById(characterId);
	}

}
