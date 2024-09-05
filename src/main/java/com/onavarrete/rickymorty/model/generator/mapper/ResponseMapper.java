package com.onavarrete.rickymorty.model.generator.mapper;

import com.onavarrete.rickymorty.model.Entity;
import com.onavarrete.rickymorty.model.ResponseDto;

public abstract class ResponseMapper<T extends ResponseDto, R extends Entity> {
	
	  public abstract R mapResponse(T dto);

}

/***
* cambio en denominaciones para disminuir scope de clases genéricas que permiten generar mapeos de parámetros a la hora de crear objetos
***/