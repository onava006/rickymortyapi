package com.onavarrete.rickymorty.service.requeshandler;

import com.onavarrete.rickymorty.feignclient.exception.ResourceNotFoundException;
import com.onavarrete.rickymorty.model.entity.CharacterEntity;
import com.onavarrete.rickymorty.model.entity.CharacterOriginEntity;
import com.onavarrete.rickymorty.model.util.PatternExtractor;

public interface CartoonRequestHandler {

	public CharacterEntity findCharacterById(Integer id) throws ResourceNotFoundException;	
	
	public CharacterOriginEntity findCharacterOriginById(PatternExtractor patternExtractor, String id);
}

/***
* re denominación de interfaces y métodos para proveer sentido más específico y hacer que sean entendibles de forma más expedita 
***/ 