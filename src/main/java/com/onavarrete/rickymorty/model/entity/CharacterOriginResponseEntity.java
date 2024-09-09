package com.onavarrete.rickymorty.model.entity;

import java.util.List;

import com.onavarrete.rickymorty.model.EntityResponse;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Builder
@Data
@AllArgsConstructor
public class CharacterOriginResponseEntity implements EntityResponse {
	
	public CharacterOriginResponseEntity() {};

	Integer id;
	String name;
	String type;
	String dimension;
	List<String> residents;
	String url;
	String created;
}
