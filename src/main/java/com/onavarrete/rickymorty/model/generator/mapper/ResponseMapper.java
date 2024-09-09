package com.onavarrete.rickymorty.model.generator.mapper;

import com.onavarrete.rickymorty.model.DtoResponse;
import com.onavarrete.rickymorty.model.EntityResponse;



public abstract class ResponseMapper<T extends EntityResponse, R extends DtoResponse> {
	
	  public abstract R mapResponse(T dto);

}

/***
* cambio en denominaciones para disminuir scope de clases genéricas que permiten generar mapeos de parámetros a la hora de crear objetos
***/