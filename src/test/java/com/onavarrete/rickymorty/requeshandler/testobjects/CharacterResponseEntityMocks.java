package com.onavarrete.rickymorty.requeshandler.testobjects;

import com.onavarrete.rickymorty.model.entity.CharacterResponseEntity;
import feign.Request;
import feign.RequestTemplate;

import java.nio.charset.StandardCharsets;
import java.util.*;

public class CharacterResponseEntityMocks {


    public static CharacterResponseEntity getCharacterResponseCorrectResponse() {

        Integer mockUserId = 123;

        List<String> episodesTest = new ArrayList<>();
        episodesTest.add("ep01");
        episodesTest.add("ep02");
        episodesTest.add("ep03");

        Map<String, String> origin = new HashMap<>();
        origin.put("url", "https://rickandmortyapi.com/api/location/3");

        CharacterResponseEntity characterResponse_Correct_Response = CharacterResponseEntity.builder()
                .name("RickTest")
                .status("On Test")
                .species("Human Test")
                .type("Test")
                .episode(episodesTest)
                .origin(origin)
                .build();

        return characterResponse_Correct_Response;

    }

    public static Request getMockRequestToHandleException(){
        Map<String, Collection<String>> headers = new HashMap<>();
        headers.put("Content-Type", Collections.singletonList("application/json"));

        String body = "{\"id\":\"-12\"}";

        Request mockRequest = Request.create(Request.HttpMethod.POST,
                "http://test.test/character",
                headers,
                body.getBytes(),
                StandardCharsets.UTF_8,
                new RequestTemplate());
        return mockRequest;
    }

}
