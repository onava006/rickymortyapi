package com.onavarrete.rickymorty.requeshandler;

import com.onavarrete.rickymorty.feignclient.RickYMortyApi;
import com.onavarrete.rickymorty.feignclient.exception.ResourceNotFoundException;
import com.onavarrete.rickymorty.model.dto.CharacterProfileDto;
import com.onavarrete.rickymorty.model.entity.CharacterResponseEntity;
import com.onavarrete.rickymorty.requeshandler.testobjects.CharacterResponseEntityMocks;
import feign.FeignException;
import feign.Request;
import org.junit.Before;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;


@SpringBootTest
class RickYMortyApiRequestHandlerTest {

    @Mock private RickYMortyApi rickYMortyApiMock;
    @InjectMocks private RickYMortyApiRequestHandler rickYMortyApiRequestHandler;

    CharacterResponseEntity characterResponse_Correct_Response;

    @DisplayName("Prueba para validar que se recibe usuario con perfil")
    @BeforeEach
    void setUp() {
        characterResponse_Correct_Response = CharacterResponseEntityMocks.getCharacterResponseCorrectResponse();
    }

    @DisplayName("Prueba para validar que feign client se ejecuta una sola vez al realizar petición a la api cuando Id está correcto")
    @Test
    public void shouldInvokeFeignClientOnce() {
        // Arrange
        Integer  mockUserId = 123;
        characterResponse_Correct_Response.setId(mockUserId);
        Mockito.when(rickYMortyApiMock.getCharacterById(mockUserId)).thenReturn(characterResponse_Correct_Response);
        // Act
        rickYMortyApiRequestHandler.findCharacterById(mockUserId);
        // Assert
        Mockito.verify(rickYMortyApiMock, Mockito.times(1)).getCharacterById(mockUserId);
    }

    @DisplayName("Prueba para validar que cuando feign client envía un character, este es manejado y entregado como Dto")
    @Test
    public void should_Return_CharacterDto_When_Feign_Client_Succeeds() {
        // Arrange
        Integer  mockUserId = 1;
        characterResponse_Correct_Response.setId(mockUserId);
        Mockito.when(rickYMortyApiMock.getCharacterById(mockUserId)).thenReturn(characterResponse_Correct_Response);
        // Act
        CharacterProfileDto characterResponse_Expected_Response =  rickYMortyApiRequestHandler.findCharacterById(mockUserId);
        // Assert
        assertNotNull(characterResponse_Expected_Response);
        assertEquals("RickTest", characterResponse_Expected_Response.getName());
    }

    @DisplayName("Prueba para validar que cuando feign client arroja una FeignExeption esta es capturada y Handler hace un throw ResourceNotFoundException")
    @Test
    void should_Handle_Feign_Client_Exceptionshould_Handle_Feign_Client_Exception() {
        // Arrange
        Integer wrong_user_id = -12;
        Request mockRequest = CharacterResponseEntityMocks.getMockRequestToHandleException();
        // Act
        Mockito.when(rickYMortyApiMock.getCharacterById(wrong_user_id)).thenThrow(new FeignException.NotFound("User not found", mockRequest, null, null));
        // Assert
        assertThrows(ResourceNotFoundException.class, () -> {
            rickYMortyApiRequestHandler.findCharacterById(wrong_user_id);
         });

    }



}