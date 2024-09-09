package com.onavarrete.rickymorty.model.dto;

import com.onavarrete.rickymorty.model.DtoResponse;
import com.onavarrete.rickymorty.model.entity.CharacterOriginResponseEntity;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
@Builder
public class CharacterProfileDto implements DtoResponse, Serializable {

    Integer id;
    String name;
    String status;
    String species;
    String type;
    Integer episodeCount;
    CharacterOriginDto origin;

    public void setOrigin(CharacterOriginDto characterOrigin) {
        origin.setDimension(characterOrigin.getDimension());
        origin.setName(characterOrigin.getName());
        origin.setResidents(characterOrigin.getResidents());
    }



}
