package com.onavarrete.rickymorty.service.requeshandler;

import java.util.Optional;
import java.util.function.Function;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.onavarrete.rickymorty.feignclient.RickYMortyApi;
import com.onavarrete.rickymorty.feignclient.exception.ResourceNotFoundException;
import com.onavarrete.rickymorty.model.dto.CharacterResponseDto;
import com.onavarrete.rickymorty.model.dto.OriginResponseDto;
import com.onavarrete.rickymorty.model.entity.CharacterEntity;
import com.onavarrete.rickymorty.model.entity.CharacterOriginEntity;
import com.onavarrete.rickymorty.model.generator.mapper.CharacterMapper;
import com.onavarrete.rickymorty.model.generator.mapper.OriginMapper;
import com.onavarrete.rickymorty.model.util.PatternExtractor;


@Component
public class RickYMortyApiRequestHandler implements CartoonRequestHandler {

	RickYMortyApi api;
	CharacterMapper charMapper;	
	OriginMapper originMapper;

	
	@Autowired 
	public RickYMortyApiRequestHandler(RickYMortyApi api) {
		this.api = api;
		this.charMapper = new CharacterMapper();
		this.originMapper = new OriginMapper();	
	}
	
	
	@Override
	public CharacterEntity findCharacterById(Integer id) throws ResourceNotFoundException{

		Function<Integer, CharacterResponseDto> obtainCharacter = i -> Optional.of(api.getCharacterById(i)).orElseThrow(() -> new ResourceNotFoundException("Resource not found with id " + i));
		Function<CharacterResponseDto, CharacterEntity> mapCharacter = d -> charMapper.mapResponse(d);
		Function<Integer, CharacterEntity> requestCharacter = obtainCharacter.andThen(mapCharacter);

		return requestCharacter.apply(id);
	}
	
	@Override
	public CharacterOriginEntity findCharacterOriginById(PatternExtractor patternExtractor, String id) {
		
		Integer requestId = patternExtractor.getLocationIdFromUrl(id);		
		
		Function<Integer, OriginResponseDto> getOriginDto = (i) -> api.getOriginById(i);
		Function<OriginResponseDto, CharacterOriginEntity> getOrigin = (o) -> originMapper.mapResponse(o);
		Function<Integer, CharacterOriginEntity> requestOrigin = getOriginDto.andThen(getOrigin);

		CharacterOriginEntity origin = requestOrigin.apply(requestId);
		return origin;

	}
	
	
}

/***
 * refactorización para delegar tarea de consumir API de rick y morty para una clase que provee de la tarea
 *  uso de métodos declarados mediante las interfaces, implementación proveída por constructor y según el contexto de la implementación 
 */

