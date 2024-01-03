package com.GlobalException2.Exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;


@ControllerAdvice
public class GlobalExceptionHandler {
	
	@ExceptionHandler(NoResourceFoundException.class)
	public ResponseEntity<String> noResourceFoundExceptionHandler(NoResourceFoundException ex){
	return new ResponseEntity<String>(ex.getMessage(),HttpStatus.NOT_FOUND);	
	}

}
