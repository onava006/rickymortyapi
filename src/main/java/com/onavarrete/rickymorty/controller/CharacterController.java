package com.onavarrete.rickymorty.controller;


import com.onavarrete.rickymorty.model.dto.CharacterProfileDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.onavarrete.rickymorty.service.CharacterProfileService;

@RestController
@RequestMapping("character")
public class CharacterController {

	CharacterProfileService service;
	public CharacterController(CharacterProfileService service) {
		this.service = service;
	}

	@GetMapping("/{characterId}")
	ResponseEntity<CharacterProfileDto> getCharacter(@PathVariable Integer characterId) {

	CharacterProfileDto characterProfile = service.genCharacterProfileById(characterId);

			return new ResponseEntity<>(characterProfile, HttpStatus.OK);
	}

}
