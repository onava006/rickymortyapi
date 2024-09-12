package com.onavarrete.rickymorty.model.dto;

import java.util.List;

import com.onavarrete.rickymorty.model.DtoResponse;
import com.onavarrete.rickymorty.model.EntityResponse;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Builder
@Data
@AllArgsConstructor
public class CharacterOriginDto implements DtoResponse {
	private String name;
	private String url;
	private String dimension;
	private List<String> residents;

	public CharacterOriginDto(String url) {
		this.url = url;
	}


    public CharacterOriginDto() {

    }
}

