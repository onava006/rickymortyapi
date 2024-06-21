package com.onavarrete.rickymorty.model.dto;

import java.util.List;

import lombok.Data;

@Data
public class OriginResponseDto {

	Integer id;
	String name;
	String type;
	String dimension;
	List<String> residents;
	String url;
	String created;
}
