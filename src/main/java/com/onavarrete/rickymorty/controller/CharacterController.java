package com.onavarrete.rickymorty.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.onavarrete.rickymorty.model.dto.CharacterResponseDto;
import com.onavarrete.rickymorty.model.entity.CharacterEntity;
import com.onavarrete.rickymorty.service.CharacterService;

@RestController
@RequestMapping("character")
public class CharacterController {

	CharacterService service;
	
	public CharacterController(@Autowired CharacterService service) {
		this.service = service;
	}
		
	 @GetMapping("/{characterId}")
	ResponseEntity<CharacterEntity> getChracter(@PathVariable Integer characterId) {
		 
		 CharacterEntity character;		 
		 try {
		  character = service.getCharacterDataById(characterId);
		 } catch(Exception e) {		
			 return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
		 }		
		 return new ResponseEntity<>(character, HttpStatus.OK);     
  }
	
}
