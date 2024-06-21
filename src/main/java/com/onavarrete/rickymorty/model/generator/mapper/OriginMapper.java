package com.onavarrete.rickymorty.model.generator.mapper;

import com.onavarrete.rickymorty.model.dto.OriginResponseDto;
import com.onavarrete.rickymorty.model.entity.OriginEntity;

public class OriginMapper extends ResponseMapper<OriginResponseDto, OriginEntity>{

	@Override
	public OriginEntity mapResponse(OriginResponseDto dto) {
		
		return OriginEntity.builder().name(dto.getName())
				.url(dto.getUrl())
				.dimension(dto.getDimension())
				.residents(dto.getResidents())
				.build();
	}

}
