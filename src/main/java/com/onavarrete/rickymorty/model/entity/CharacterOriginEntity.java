package com.onavarrete.rickymorty.model.entity;

import java.util.List;

import com.onavarrete.rickymorty.model.Entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Builder
@Data
@AllArgsConstructor
public class CharacterOriginEntity implements Entity {
	
	private String name;
	private String url;
	private String dimension;
	private List<String> residents;

	public CharacterOriginEntity(String url) {
		this.url = url;
	}
	
	
}

