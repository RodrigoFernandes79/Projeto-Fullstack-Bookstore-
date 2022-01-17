package com.rodrigo.bookstore.exceptions;

import java.util.HashMap;
import java.util.Map;

import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
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
	
	@ExceptionHandler(DataIntegrityViolationException.class)
	public ResponseEntity<ApiException> validationNotFoundException(DataIntegrityViolationException ex){
		
		String fieldName = ex.getMessage();
		
		
		ApiException obj = new ApiException(fieldName);
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(obj);
}
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public Map<String,String> handleValidationException(MethodArgumentNotValidException ex){
		Map<String,String> erro =new HashMap<>();
		
		 ex.getBindingResult().getAllErrors().forEach((objetoErro)->{
			 String fieldName = ((FieldError) objetoErro).getField();
			 String errorMessage =  objetoErro.getDefaultMessage();
			 
			 erro.put(fieldName, errorMessage);
		 });
		
		return erro ;
		
	}
}
