package com.onavarrete.rickymorty.feignclient;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.onavarrete.rickymorty.model.dto.CharacterResponseDto;
import com.onavarrete.rickymorty.model.dto.OriginResponseDto;

@FeignClient(name = "rickYMortyApi", url = "https://rickandmortyapi.com/api")
public interface RickYMortyApi {
	
	    @GetMapping("/character/{id}")
	    CharacterResponseDto getCharacterById(@PathVariable("id") Long id);
	
	    @GetMapping("/location/{id}")
	    OriginResponseDto getOriginById(@PathVariable("id") Long id);
	    
}
