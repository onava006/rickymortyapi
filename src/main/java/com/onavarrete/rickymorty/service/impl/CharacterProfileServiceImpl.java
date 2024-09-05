package com.onavarrete.rickymorty.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.onavarrete.rickymorty.feignclient.exception.ResourceNotFoundException;
import com.onavarrete.rickymorty.model.Entity;
import com.onavarrete.rickymorty.service.CharacterProfileService;
import com.onavarrete.rickymorty.service.requeshandler.CartoonRequestHandler;

import com.onavarrete.rickymorty.model.entity.CharacterEntity;
import com.onavarrete.rickymorty.model.entity.ErrorEntity;
import com.onavarrete.rickymorty.model.util.PatternExtractor;
import com.onavarrete.rickymorty.model.util.RickYMortyApiPatternExtractor;
import com.onavarrete.rickymorty.model.entity.CharacterOriginEntity;

@Service
public class CharacterProfileServiceImpl implements CharacterProfileService {

	
	CartoonRequestHandler apiHandler;
	PatternExtractor patternExtractor;
	
	@Autowired
	public CharacterProfileServiceImpl(CartoonRequestHandler apiHandler) {
		this.apiHandler = apiHandler;
		this.patternExtractor = new RickYMortyApiPatternExtractor();

	}


	@Override
	public ResponseEntity<Entity> genCharacterProfileById(Integer id) {
		
		CharacterEntity character;
		CharacterOriginEntity origin;
		
		try {
				
			character = apiHandler.findCharacterById(id);
			origin = apiHandler.findCharacterOriginById(patternExtractor, character.getOrigin().getUrl());
		}
		catch (ResourceNotFoundException e) {
			ErrorEntity errorEntity = new ErrorEntity(e.getMessage(), "Utilizar otro id");
			return new ResponseEntity<>(errorEntity, HttpStatus.NOT_FOUND);
		}		
		
		catch (Exception e) {
			System.out.print(e.getMessage());
			System.out.print(e.getCause());
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
		character.setOrigin(origin);		
		return new ResponseEntity<>(character, HttpStatus.OK);
		
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
















