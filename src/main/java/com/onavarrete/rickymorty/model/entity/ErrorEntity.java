package com.onavarrete.rickymorty.model.entity;

import com.onavarrete.rickymorty.model.Entity;

import lombok.Getter;

@Getter
public class ErrorEntity implements Entity {
	
	public ErrorEntity(String errorStatus, String errorMessage) {
		this.errorMessage = errorMessage;
		this.errorStatus = errorStatus;
	}
	
	String errorStatus; 
	String errorMessage;

}
