package com.onavarrete.rickymorty.model.generator.mapper;

import com.onavarrete.rickymorty.model.dto.OriginResponseDto;
import com.onavarrete.rickymorty.model.entity.CharacterOriginEntity;

public class OriginMapper extends ResponseMapper<OriginResponseDto, CharacterOriginEntity>{

	@Override
	public CharacterOriginEntity mapResponse(OriginResponseDto dto) {
		
		return CharacterOriginEntity.builder().name(dto.getName())
				.url(dto.getUrl())
				.dimension(dto.getDimension())
				.residents(dto.getResidents())
				.build();
	}

}
