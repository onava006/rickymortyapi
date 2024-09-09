package com.onavarrete.rickymorty.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.onavarrete.rickymorty.feignclient.exception.ResourceNotFoundException;
import com.onavarrete.rickymorty.model.Entity;
import com.onavarrete.rickymorty.service.CharacterProfileService;
import com.onavarrete.rickymorty.requeshandler.requeshandler.ApiRequestHandler;

import com.onavarrete.rickymorty.model.entity.CharacterEntity;
import com.onavarrete.rickymorty.model.entity.ErrorEntity;
import com.onavarrete.rickymorty.model.util.PatternExtractor;
import com.onavarrete.rickymorty.model.util.RickYMortyApiPatternExtractor;
import com.onavarrete.rickymorty.model.entity.CharacterOriginEntity;

@Service
public class CharacterProfileServiceImpl implements CharacterProfileService {

	ApiRequestHandler apiHandler;
	PatternExtractor patternExtractor;
	
	@Autowired
	public CharacterProfileServiceImpl(ApiRequestHandler apiHandler) {
		this.apiHandler = apiHandler;
		this.patternExtractor = new RickYMortyApiPatternExtractor();
	}

	@Override
	public CharacterEntity genCharacterProfileById(Integer id) {

		CharacterEntity character;
		CharacterOriginEntity origin;
		character = apiHandler.findCharacterById(id);

		if(character != null){
			origin = apiHandler.findCharacterOriginById(patternExtractor, character.getOrigin().getUrl());
			character.setOrigin(origin);
		}
		return character;
	}
}

/***
 * refactorización para delegar tarea de consumir API de rick y morty para una clase que provee de la tarea (RickYMortyApiRequestHandler)
 *  uso de métodos declarados mediante las interfaces (CartoonRequestHandler), implementación proveída por constructor y según el contexto de la implementación
 *  
 *  clase encargada de procesar patrones específicos para api de rick y morty en linea 43 pasada por parámetro del método. 
 */


/***
 * se reconfigura servicio solo para manejar logica de negocio de las respuestas provenientes desde las clases delegadas  
 */
















