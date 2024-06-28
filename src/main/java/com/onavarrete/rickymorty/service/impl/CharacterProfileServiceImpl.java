package com.onavarrete.rickymorty.service.impl;

import java.util.Optional;
import java.util.function.Function;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.onavarrete.rickymorty.feignclient.RickYMortyApi;
import com.onavarrete.rickymorty.feignclient.exception.ResourceNotFoundException;
import com.onavarrete.rickymorty.model.Entity;
import com.onavarrete.rickymorty.model.dto.CharacterResponseDto;
import com.onavarrete.rickymorty.model.dto.OriginResponseDto;
import com.onavarrete.rickymorty.service.CharacterProfileService;

import com.onavarrete.rickymorty.model.entity.CharacterEntity;
import com.onavarrete.rickymorty.model.entity.ErrorEntity;
import com.onavarrete.rickymorty.model.entity.OriginEntity;
import com.onavarrete.rickymorty.model.generator.mapper.CharacterMapper;
import com.onavarrete.rickymorty.model.generator.mapper.OriginMapper;
import com.onavarrete.rickymorty.model.util.PatternExtractor;

@Service
public class CharacterProfileServiceImpl implements CharacterProfileService {

	RickYMortyApi api;
	CharacterMapper charMapper;	
	OriginMapper originMapper;
	
	public CharacterProfileServiceImpl(@Autowired RickYMortyApi api) {
		this.api = api;
		charMapper = new CharacterMapper();
		originMapper = new OriginMapper();	
	}

	@Override
	public ResponseEntity<Entity> getCharacterDataById(Integer id) {
		
		CharacterEntity character;
		OriginEntity origin;
		
		try {
			character = findCharacterById(id);
			origin = findOriginById(character.getOrigin().getUrl());
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

	private CharacterEntity findCharacterById(Integer id) throws ResourceNotFoundException{

		Function<Integer, CharacterResponseDto> obtainCharacter = i -> Optional.of(api.getCharacterById(i)).orElseThrow(() -> new ResourceNotFoundException("Resource not found with id " + i));
		Function<CharacterResponseDto, CharacterEntity> mapCharacter = d -> charMapper.mapResponse(d);
		Function<Integer, CharacterEntity> requestCharacter = obtainCharacter.andThen(mapCharacter);

		return requestCharacter.apply(id);
	}
	

	private OriginEntity findOriginById(String id) {
		
		Integer requestId = PatternExtractor.getIdFromLocationUrl(id);		
		
		Function<Integer, OriginResponseDto> getOriginDto = (i) -> api.getOriginById(i);
		Function<OriginResponseDto, OriginEntity> getOrigin = (o) -> originMapper.mapResponse(o);
		Function<Integer, OriginEntity> requestOrigin = getOriginDto.andThen(getOrigin);

		OriginEntity origin = requestOrigin.apply(requestId);
		return origin;

	}
}




















