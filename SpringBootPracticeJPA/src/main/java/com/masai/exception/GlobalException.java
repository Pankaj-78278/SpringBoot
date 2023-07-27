package com.masai.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalException  {
	
	@ExceptionHandler(StudentException.class)
	public ResponseEntity<String> myExceptionHandler(StudentException se){
		return new ResponseEntity<String>(HttpStatus.BAD_REQUEST);
	}
	
	
}
