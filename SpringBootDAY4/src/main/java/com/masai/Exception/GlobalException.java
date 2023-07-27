package com.masai.Exception;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.NoHandlerFoundException;


@ControllerAdvice
public class GlobalException  {

	@ExceptionHandler(InvalidIdException.class)
	public ResponseEntity<ErrorDetail> myExpHandler(InvalidIdException ie,WebRequest req) {
		
		ErrorDetail err =new ErrorDetail();
		err.setTimestamp(LocalDateTime.now());
		err.setMessage(ie.getMessage());
		err.setDetails(req.getDescription(false));
	
		
		return new ResponseEntity<ErrorDetail>(err,HttpStatus.BAD_REQUEST);
	}
	
	
	@ExceptionHandler(Exception.class)
	public ResponseEntity<ErrorDetail> myExpHandler(Exception ie, WebRequest req) {
		
		
		
		ErrorDetail err =new ErrorDetail();
		err.setTimestamp(LocalDateTime.now());
		err.setMessage(ie.getMessage());
		err.setDetails(req.getDescription(false));
	
		
		return new ResponseEntity<ErrorDetail>(err,HttpStatus.BAD_REQUEST);
	}
	
	
	
	@ExceptionHandler(NoHandlerFoundException.class)
	
	public ResponseEntity<ErrorDetail> mynotFoundHandler(NoHandlerFoundException nfe,WebRequest req) {
	
	ErrorDetail err=new ErrorDetail(LocalDateTime.now(), nfe.getMessage(), req.getDescription(false));
	
	return new ResponseEntity<>(err,HttpStatus.BAD_REQUEST);
	}

	
	
	
}
