package com.onavarrete.rickymorty.model.entity;

import java.util.List;

import com.onavarrete.rickymorty.model.ResponseEntity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Builder
@Data
@AllArgsConstructor
public class OriginEntity implements ResponseEntity {
	
	private String name;
	private String url;
	private String dimension;
	private List<String> residents;

	public OriginEntity(String url) {
		this.url = url;
	}
	
	
}

