package com.onavarrete.rickymorty.service.testobjects;

import com.onavarrete.rickymorty.model.dto.CharacterOriginDto;
import com.onavarrete.rickymorty.model.dto.CharacterProfileDto;
import com.onavarrete.rickymorty.model.entity.CharacterResponseEntity;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CharacterProfileDtoMocks {

    public static CharacterProfileDto mock_CharacterResponseCorrectResponse() {

        Integer mockUserId = 123;
        CharacterOriginDto characterOriginDto_Origin_Url_Only = new CharacterOriginDto("https://rickandmortyapi.com/api/location/1");

        CharacterProfileDto characterResponseDto_Correct_Response = CharacterProfileDto.builder()
                .id(mockUserId)
                .name("RickTest")
                .status("On Test")
                .species("Human Test")
                .type("Test")
                .episodeCount(3)
                .origin(characterOriginDto_Origin_Url_Only)
                .build();

        return characterResponseDto_Correct_Response;
    }

    public static CharacterOriginDto mock_OriginResponseDto() {
        CharacterOriginDto characterOriginDto_CorrectResponse = CharacterOriginDto.builder()
                .name("Test_Name")
                .url("https://rickandmortyapi.com/api/location/1")
                .dimension("Dimension C-137")
                .build();
        return characterOriginDto_CorrectResponse;
    }


    public static CharacterProfileDto mock_CharacterProfileMethodExpectedResult() {

        Integer mockUserId = 123;

        CharacterProfileDto characterResponseDto_ExpectedResult = CharacterProfileDto.builder()
                .id(mockUserId)
                .name("RickTest")
                .status("On Test")
                .species("Human Test")
                .type("Test")
                .episodeCount(3)
                .origin(mock_OriginResponseDto())
                .build();

        return characterResponseDto_ExpectedResult;
    }

}