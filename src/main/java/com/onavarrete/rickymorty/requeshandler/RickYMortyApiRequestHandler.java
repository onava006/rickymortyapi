package com.onavarrete.rickymorty.requeshandler;

import java.util.Optional;
import java.util.function.Function;

import com.onavarrete.rickymorty.model.dto.CharacterProfileDto;
import com.onavarrete.rickymorty.model.entity.CharacterResponseEntity;
import com.onavarrete.rickymorty.model.util.RickYMortyApiPatternExtractor;
import feign.FeignException;
import org.springframework.stereotype.Component;

import com.onavarrete.rickymorty.feignclient.RickYMortyApi;
import com.onavarrete.rickymorty.feignclient.exception.ResourceNotFoundException;
import com.onavarrete.rickymorty.model.entity.CharacterOriginResponseEntity;
import com.onavarrete.rickymorty.model.dto.CharacterOriginDto;
import com.onavarrete.rickymorty.model.generator.mapper.CharacterMapper;
import com.onavarrete.rickymorty.model.generator.mapper.OriginMapper;
import com.onavarrete.rickymorty.model.util.PatternExtractor;


@Component
public class RickYMortyApiRequestHandler implements RickYMortyRequestHandler {

    RickYMortyApi rickYMortyApi;
    PatternExtractor patternExtractor;
    CharacterMapper charMapper;
    OriginMapper originMapper;

    public RickYMortyApiRequestHandler(RickYMortyApi rickYMortyApi, RickYMortyApiPatternExtractor rickYMortyApiPatternExtractor, CharacterMapper charMapper,
                                       OriginMapper originMapper) {
        this.rickYMortyApi = rickYMortyApi;
        this.patternExtractor = rickYMortyApiPatternExtractor;
        this.charMapper = charMapper;
        this.originMapper = originMapper;
    }

    @Override
    public CharacterProfileDto findCharacterById(Integer id) throws ResourceNotFoundException {

        CharacterProfileDto characterApiResponse;

        Function<Integer, CharacterResponseEntity> obtainCharacter = i -> Optional.of(rickYMortyApi.getCharacterById(i)).orElseThrow(() -> new ResourceNotFoundException("Resource not found with id " + i));
        Function<CharacterResponseEntity, CharacterProfileDto> mapCharacter = d -> charMapper.mapResponse(d);
        Function<Integer, CharacterProfileDto> requestCharacter = obtainCharacter.andThen(mapCharacter);

        try {
            characterApiResponse = requestCharacter.apply(id);
        } catch (FeignException e) {
            throw new ResourceNotFoundException("Character not found");
        }
        return characterApiResponse;
    }

    public CharacterOriginDto findCharacterOriginById(String id) {

        Integer requestId = patternExtractor.getLocationIdFromUrl(id);
        CharacterOriginDto characterOrigin;

        Function<Integer, CharacterOriginResponseEntity> getOriginDto = (i) -> rickYMortyApi.getOriginById(i);
        Function<CharacterOriginResponseEntity, CharacterOriginDto> getOrigin = (o) -> originMapper.mapResponse(o);
        Function<Integer, CharacterOriginDto> requestOrigin = getOriginDto.andThen(getOrigin);

        try {
            characterOrigin = requestOrigin.apply(requestId);
        } catch (Exception e) {
            return null;
        }
        return characterOrigin;
    }
}

/***
 * refactorización para delegar tarea de consumir API de rick y morty para una clase que provee de la tarea
 *  uso de métodos declarados mediante las interfaces, implementación proveída por constructor y según el contexto de la implementación 
 */

