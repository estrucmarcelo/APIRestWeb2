package br.com.senac.exception;

import java.util.Optional;

import br.com.senac.entity.Estudante;

public class ObjectNotFoundException extends RuntimeException{

	public ObjectNotFoundException(String message, Throwable cause) {
		super(message,cause);
	}
	
	public ObjectNotFoundException(String message) {
		super(message);
	}


}
