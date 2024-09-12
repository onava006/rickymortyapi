package com.onavarrete.rickymorty.service;

import com.onavarrete.rickymorty.feignclient.exception.ResourceNotFoundException;
import com.onavarrete.rickymorty.model.dto.CharacterOriginDto;
import com.onavarrete.rickymorty.model.dto.CharacterProfileDto;
import com.onavarrete.rickymorty.model.util.PatternExtractor;
import com.onavarrete.rickymorty.model.util.RickYMortyApiPatternExtractor;
import com.onavarrete.rickymorty.requeshandler.RickYMortyRequestHandler;
import com.onavarrete.rickymorty.service.impl.CharacterProfileServiceImpl;
import com.onavarrete.rickymorty.service.testobjects.CharacterProfileDtoMocks;
import feign.FeignException;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.Assert.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.*;

@SpringBootTest
class CharacterProfileServiceImplTest {

    @Mock RickYMortyRequestHandler apiHandler;

    @InjectMocks
    CharacterProfileServiceImpl characterProfileService;

    @DisplayName("Prueba ejecutando método, el perfil del CharacterProfileDto resultante posee ambas peticiones a la api en un solo objeto")
    @Test
    void should_Return_Complete_CharacterProfileDto_When_Api_Request_Succeeds() {
        // Arrange
        Integer mock_correctId = 1;
        CharacterOriginDto mock_OriginResponse = CharacterProfileDtoMocks.mock_OriginResponseDto();
        CharacterProfileDto mock_CharacterResponse = CharacterProfileDtoMocks.mock_CharacterResponseCorrectResponse();

        CharacterProfileDto mock_CharacterProfileMethodExpectedResult =  CharacterProfileDtoMocks.mock_CharacterProfileMethodExpectedResult();

        when(apiHandler.findCharacterById(mock_correctId)).thenReturn(mock_CharacterResponse);
        when(apiHandler.findCharacterOriginById("https://rickandmortyapi.com/api/location/1")).thenReturn(mock_OriginResponse);

        // Act
        CharacterProfileDto result = characterProfileService.genCharacterProfileById(mock_correctId);

        //Assert
        Assertions.assertThat(result)
                .usingRecursiveComparison()
                .isEqualTo(mock_CharacterProfileMethodExpectedResult);

        //assertEquals(mock_OriginResponse, result.getOrigin());
    }

    @DisplayName("Prueba que emula excepción arrojada por Api handler al proporcionar un id que no existe en base de datos de la api de rick y morty")
    @Test
    void should_throw_ResourceNotFoundException_when_unknown_id_used() {

        Integer mock_incorrect_id = 999;
        when(apiHandler.findCharacterById(mock_incorrect_id)).thenThrow(new ResourceNotFoundException("Character not found"));
        assertThrows(ResourceNotFoundException.class, () -> characterProfileService.genCharacterProfileById(mock_incorrect_id));
    }
}