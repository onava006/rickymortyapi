package com.onavarrete.rickymorty.model.entity;

import com.onavarrete.rickymorty.model.Entity;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;


@Builder
@Getter
@Setter
public class CharacterEntity implements Entity{
	
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

