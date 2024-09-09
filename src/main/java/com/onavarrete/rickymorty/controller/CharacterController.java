package com.onavarrete.rickymorty.controller;


import com.onavarrete.rickymorty.model.entity.ErrorEntity;
import org.springframework.http.HttpStatus;
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
	ResponseEntity<Entity> getCharacter(@PathVariable Integer characterId) {

	Entity characterProfile = service.genCharacterProfileById(characterId);

		if (characterProfile != null) {
			return new ResponseEntity<>(characterProfile, HttpStatus.OK);
		} else {
			return  new ResponseEntity<>(new ErrorEntity("Not found", "No se ha encontrado el personaje"), HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

}
