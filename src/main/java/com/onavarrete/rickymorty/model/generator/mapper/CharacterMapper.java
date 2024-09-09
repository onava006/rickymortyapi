package com.onavarrete.rickymorty.model.generator.mapper;

import com.onavarrete.rickymorty.model.dto.CharacterOriginDto;
import com.onavarrete.rickymorty.model.dto.CharacterProfileDto;

import com.onavarrete.rickymorty.model.entity.CharacterResponseEntity;

public class CharacterMapper extends ResponseMapper<CharacterResponseEntity, CharacterProfileDto>{

	public CharacterMapper() {}
	
	@Override
	public CharacterProfileDto mapResponse(CharacterResponseEntity characterResponse) {

		Long episodeCount = characterResponse.getEpisode().stream().count();

		CharacterProfileDto entity = CharacterProfileDto.builder()
												.id(characterResponse.getId())
												.name(characterResponse.getName())
												.status(characterResponse.getStatus())
												.species(characterResponse.getSpecies())
												.type(characterResponse.getType())
												.episodeCount(Integer.valueOf(episodeCount.intValue()))
												.origin(new CharacterOriginDto(characterResponse.getOrigin().get("url")))
												.build();
		
		return entity;
	}

}
