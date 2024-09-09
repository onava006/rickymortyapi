package com.onavarrete.rickymorty.service.impl;

import com.onavarrete.rickymorty.model.dto.CharacterOriginDto;
import com.onavarrete.rickymorty.model.dto.CharacterProfileDto;
import com.onavarrete.rickymorty.model.entity.CharacterOriginResponseEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.onavarrete.rickymorty.service.CharacterProfileService;
import com.onavarrete.rickymorty.requeshandler.requeshandler.RickYMortyRequestHandler;

import com.onavarrete.rickymorty.model.util.PatternExtractor;
import com.onavarrete.rickymorty.model.util.RickYMortyApiPatternExtractor;

@Service
public class CharacterProfileServiceImpl implements CharacterProfileService {

	RickYMortyRequestHandler apiHandler;
	PatternExtractor patternExtractor;
	
	@Autowired
	public CharacterProfileServiceImpl(RickYMortyRequestHandler apiHandler) {
		this.apiHandler = apiHandler;
		this.patternExtractor = new RickYMortyApiPatternExtractor();
	}

	@Override
	public CharacterProfileDto genCharacterProfileById(Integer id) {

		CharacterProfileDto characterProfile;
		CharacterOriginDto characterOrigin;

		characterProfile = apiHandler.findCharacterById(id);
		characterOrigin = apiHandler.findCharacterOriginById(this.patternExtractor, characterProfile.getOrigin().getUrl());
		characterProfile.setOrigin(characterOrigin);

		return characterProfile;
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
















