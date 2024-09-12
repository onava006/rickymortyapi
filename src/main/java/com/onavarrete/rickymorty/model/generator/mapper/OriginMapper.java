package com.onavarrete.rickymorty.model.generator.mapper;

import com.onavarrete.rickymorty.model.dto.CharacterOriginDto;
import com.onavarrete.rickymorty.model.entity.CharacterOriginResponseEntity;
import org.springframework.stereotype.Component;

@Component
public class OriginMapper extends ResponseMapper<CharacterOriginResponseEntity, CharacterOriginDto>{

	@Override
	public CharacterOriginDto mapResponse(CharacterOriginResponseEntity originResponse) {
		
		return CharacterOriginDto.builder().name(originResponse.getName())
				.url(originResponse.getUrl())
				.dimension(originResponse.getDimension())
				.residents(originResponse.getResidents())
				.build();
	}

}
