package br.com.senac.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import jakarta.servlet.http.HttpServletRequest;

@ControllerAdvice
public class ResourceExceptionHandler {

	
	@ExceptionHandler(ObjectNotFoundException.class)
	public ResponseEntity<StandardError> objectNotFound(ObjectNotFoundException ex, HttpServletRequest request) {
		
		ValidationError errors = new ValidationError(System.currentTimeMillis(),
													HttpStatus.NOT_FOUND.value(),
													"Object not found",
													ex.getMessage(),
													request.getRequestURI());
		
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(errors);
		
	}
	
	
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<StandardError> validatioError(MethodArgumentNotValidException ex,HttpServletRequest request) {
		
		ValidationError errors = new ValidationError(System.currentTimeMillis(),
													HttpStatus.BAD_REQUEST.value(),
													"Campo vazio",
													"Erro na validação de campos",
													request.getRequestURI());
		
		
		for(FieldError x : ex.getBindingResult().getFieldErrors()) {
			errors.addError(x.getField(), x.getDefaultMessage());
			
		}
		
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errors);
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
}
