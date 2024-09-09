package com.onavarrete.rickymorty.service;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.onavarrete.rickymorty.model.dto.CharacterDto;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.onavarrete.rickymorty.model.entity.CharacterOriginDto;
import com.onavarrete.rickymorty.model.dto.CharacterOriginEntity;
import com.onavarrete.rickymorty.service.impl.CharacterProfileServiceImpl;
import com.onavarrete.rickymorty.requeshandler.requeshandler.RickYMortyRequestHandler;

@ExtendWith(MockitoExtension.class)
public class CharacterProfileServiceImplTest {
	
	
	@Mock
    private RickYMortyRequestHandler api;

    @InjectMocks
    private CharacterProfileServiceImpl service;

    private com.onavarrete.rickymorty.model.dto.CharacterDto characterDto;
    
    private CharacterOriginEntity originEntity;
    


    private CharacterOriginDto originDto;
    
        
//    @BeforeEach
//    public  void setInfo() {
//
//    	List<String> episodesTest = new ArrayList<>();
//    	episodesTest.add("ep01");
//    	episodesTest.add("ep02");
//    	episodesTest.add("ep03");
//
//    	List<String> residentsTest = new ArrayList<>();
//
//    	residentsTest.add("https://rickandmortyapi.com/api/character/3\"");
//    	residentsTest.add("https://rickandmortyapi.com/api/character/4\"");
//
//    	Map<String,String> origin = new HashMap<>();
//    	origin.put("url", "https://rickandmortyapi.com/api/location/3");
//
//    	characterDto = CharacterDto.builder()
//    			.id(123)
//				.name("RickTest")
//				.status("On Test")
//				.species("Human Test")
//				.type("Test")
//				.episode(episodesTest)
//				.origin(origin)
//				.build();
//
//    	 originDto = OriginResponseDto.builder()
//    			 .id(10)
//    			 .name("Earth test")
//    			 .type("Planet")
//    			 .dimension("Replacement Dimension Test")
//    			 .residents(residentsTest)
//    			 .build();
//
//
//    	  service = new CharacterProfileServiceImpl(api);
//    }
    
    /***
    @DisplayName("Prueba para validar que se recibe usuario con perfil")
    @Test
    public void test_character_profile_and_receive_data() {
    	
    	 when(api.findCharacterById(123)).thenReturn(characterDto);
    	 when(api.getOriginById(3)).thenReturn(originDto);
    	 
    	 
    	 ResponseEntity<ApiResponse> testResponse =  service.getCharacterDataById(123);
    	 
    	 assertEquals(HttpStatus.OK, testResponse.getStatusCode());
    	
    }
    
    ***/
	
	

}
