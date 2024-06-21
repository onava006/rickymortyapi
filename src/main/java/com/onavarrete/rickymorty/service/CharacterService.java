package com.onavarrete.rickymorty.service;

import com.onavarrete.rickymorty.model.entity.CharacterEntity;
import com.onavarrete.rickymorty.model.entity.OriginEntity;
 

public interface CharacterService {
	
	
	CharacterEntity getCharacterDataById(Integer id);
	
	CharacterEntity findCharacterById(Integer id);

	OriginEntity findOriginById(String id);
	
}

