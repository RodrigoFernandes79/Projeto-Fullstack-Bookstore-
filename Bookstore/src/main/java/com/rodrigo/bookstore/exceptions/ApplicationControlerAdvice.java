package com.rodrigo.bookstore.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.server.ResponseStatusException;

@RestControllerAdvice
public class ApplicationControlerAdvice {

	
	@ExceptionHandler(ResponseStatusException.class)
	public ResponseEntity<ApiException> validationNotFoundException(ResponseStatusException ex){
		
		String fieldName = ex.getMessage();
		String fieldError = ex.getReason();
		
		ApiException obj = new ApiException(fieldName, fieldError);
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(obj);
	}
}
