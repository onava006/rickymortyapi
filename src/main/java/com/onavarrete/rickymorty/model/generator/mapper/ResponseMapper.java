package com.onavarrete.rickymorty.model.generator.mapper;

public abstract class ResponseMapper<T,R> {
	
	  public abstract R mapResponse(T dto);

}
