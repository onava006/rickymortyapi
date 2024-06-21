package com.onavarrete.rickymorty.model.generator.mapper;

import com.onavarrete.rickymorty.model.dto.CharacterResponseDto;
import com.onavarrete.rickymorty.model.entity.CharacterEntity;
import com.onavarrete.rickymorty.model.entity.OriginEntity;

public class CharacterMapper extends ResponseMapper<CharacterResponseDto, CharacterEntity>{

	public CharacterMapper() {}
	
	@Override
	public CharacterEntity mapResponse(CharacterResponseDto dto) {
		
		Long episodeCount = dto.getEpisode().stream().count();
		
		CharacterEntity entity = CharacterEntity.builder()
												.id(dto.getId())
												.name(dto.getName())
												.status(dto.getStatus())
												.species(dto.getSpecies())
												.type(dto.getType())
												.episodeCount(Integer.valueOf(episodeCount.intValue()))
												.origin(new OriginEntity(dto.getOrigin().get("url")))
												.build();
		
		return entity;
	}

}
