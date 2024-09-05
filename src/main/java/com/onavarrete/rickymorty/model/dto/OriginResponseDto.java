package com.onavarrete.rickymorty.model.dto;

import java.util.List;

import com.onavarrete.rickymorty.model.ResponseDto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Builder
@Data
@AllArgsConstructor
public class OriginResponseDto implements ResponseDto {
	
	public OriginResponseDto() {};

	Integer id;
	String name;
	String type;
	String dimension;
	List<String> residents;
	String url;
	String created;
}
