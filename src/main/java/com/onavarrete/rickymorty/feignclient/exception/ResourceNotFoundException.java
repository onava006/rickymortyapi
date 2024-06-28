package com.onavarrete.rickymorty.feignclient.exception;

import java.io.Serializable;

public class ResourceNotFoundException extends RuntimeException implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -2626522601764891948L;


	public ResourceNotFoundException(String message) {
        super(message);
    }
}
