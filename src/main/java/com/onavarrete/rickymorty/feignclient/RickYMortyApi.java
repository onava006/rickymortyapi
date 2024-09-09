package com.onavarrete.rickymorty.feignclient;


import com.onavarrete.rickymorty.model.entity.CharacterResponseEntity;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.onavarrete.rickymorty.model.entity.CharacterOriginResponseEntity;

@FeignClient(name = "rickYMortyApi", url = "https://rickandmortyapi.com/api")
public interface RickYMortyApi {
	
	    @GetMapping("/character/{id}")
		CharacterResponseEntity getCharacterById(@PathVariable("id") Integer id);
	
	    @GetMapping("/location/{id}")
		CharacterOriginResponseEntity getOriginById(@PathVariable("id") Integer id);
	    
}
