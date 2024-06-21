package com.onavarrete.rickymorty.service.impl;

import java.util.function.Function;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.onavarrete.rickymorty.feignclient.RickYMortyApi;
import com.onavarrete.rickymorty.model.dto.CharacterResponseDto;
import com.onavarrete.rickymorty.model.dto.OriginResponseDto;
import com.onavarrete.rickymorty.service.CharacterService;

import com.onavarrete.rickymorty.model.entity.CharacterEntity;
import com.onavarrete.rickymorty.model.entity.OriginEntity;
import com.onavarrete.rickymorty.model.generator.mapper.CharacterMapper;
import com.onavarrete.rickymorty.model.generator.mapper.OriginMapper;

@Service
public class CharacterServiceImpl implements CharacterService {

	RickYMortyApi api;

	CharacterMapper charMapper;
	OriginMapper originMapper;

	public CharacterServiceImpl(@Autowired RickYMortyApi api) {
		this.api = api;
		charMapper = new CharacterMapper();
		originMapper = new OriginMapper();
	}

	@Override
	public CharacterEntity getCharacterDataById(Integer id) {

		CharacterEntity character = findCharacterById(id);
		OriginEntity origin = findOriginById(character.getOrigin().getUrl());
		character.setOrigin(origin);

		return character;
	}

	@Override
	public CharacterEntity findCharacterById(Integer id) {

		Function<Integer, CharacterResponseDto> obtainCharacter = i -> api.getCharacterById(Long.valueOf(id));
		Function<CharacterResponseDto, CharacterEntity> mapCharacter = d -> charMapper.mapResponse(d);
		Function<Integer, CharacterEntity> requestCharacter = obtainCharacter.andThen(mapCharacter);

		return requestCharacter.apply(id);
	}

	@Override
	public OriginEntity findOriginById(String url) {

		Function<Integer, OriginResponseDto> getOriginDto = (e) -> api.getOriginById(Long.valueOf(3));
		Function<OriginResponseDto, OriginEntity> getOrigin = (d) -> originMapper.mapResponse(d);
		Function<Integer, OriginEntity> requestOrigin = getOriginDto.andThen(getOrigin);

		OriginEntity origin = requestOrigin.apply(3);
		return origin;

	}

}
