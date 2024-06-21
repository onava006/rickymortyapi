package com.onavarrete.rickymorty.model.entity;

import com.onavarrete.rickymorty.model.ResponseEntity;

import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;


@Builder
@Getter
@Setter
public class CharacterEntity implements ResponseEntity{
	
	Integer id;
	String name;
	String status;
	String species;
	String type;
	Integer episodeCount;
	OriginEntity origin;
	
	public void setOrigin(OriginEntity o) {
		origin.setDimension(o.getDimension());
		origin.setName(o.getName());
		origin.setResidents(o.getResidents());
	}

}

