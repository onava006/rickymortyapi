package com.onavarrete.rickymorty.model.dto;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Builder
@Data
@AllArgsConstructor
public class OriginResponseDto {
	
	public OriginResponseDto() {};

	Integer id;
	String name;
	String type;
	String dimension;
	List<String> residents;
	String url;
	String created;
}
