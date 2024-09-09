package com.onavarrete.rickymorty.requeshandler.requeshandler;

import com.onavarrete.rickymorty.feignclient.exception.ResourceNotFoundException;
import com.onavarrete.rickymorty.model.dto.CharacterProfileDto;
import com.onavarrete.rickymorty.model.dto.CharacterOriginDto;
import com.onavarrete.rickymorty.model.util.PatternExtractor;

public interface RickYMortyRequestHandler {

	public CharacterProfileDto findCharacterById(Integer id) throws ResourceNotFoundException;
	
	public CharacterOriginDto findCharacterOriginById(PatternExtractor patternExtractor, String id);
}

/***
* re denominación de interfaces y métodos para proveer sentido más específico y hacer que sean entendibles de forma más expedita 
***/ 