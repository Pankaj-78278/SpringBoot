package com.masai.exception;

import java.time.LocalDateTime;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.NoHandlerFoundException;

@ControllerAdvice
public class GlobalProductException {
	
	
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<MyErrorDetail> validationException(MethodArgumentNotValidException ma,WebRequest req){
		
		MyErrorDetail err= new MyErrorDetail();
		err.setTimestamp(LocalDateTime.now());
		err.setMessage("Invalid validation");
		err.setDetails(ma.getBindingResult().getFieldError().getDefaultMessage());
		
		return new ResponseEntity<MyErrorDetail>(err,HttpStatus.BAD_REQUEST);
	}
	
	
	@ExceptionHandler(UserException.class )
	public ResponseEntity<MyErrorDetail> myExceptionHandler(UserException ip,WebRequest req){
		
		MyErrorDetail err =new MyErrorDetail();
		
		err.setTimestamp(LocalDateTime.now());
		err.setMessage(ip.getMessage());
		err.setDetails(req.getDescription(false));
		
		return new ResponseEntity<MyErrorDetail>(err,HttpStatus.BAD_REQUEST); 
	}
	@ExceptionHandler(BlogException.class )
	public ResponseEntity<MyErrorDetail> myExceptionHandler(BlogException ip,WebRequest req){
		
		MyErrorDetail err =new MyErrorDetail();
		
		err.setTimestamp(LocalDateTime.now());
		err.setMessage(ip.getMessage());
		err.setDetails(req.getDescription(false));
		
		return new ResponseEntity<MyErrorDetail>(err,HttpStatus.BAD_REQUEST); 
	}
	@ExceptionHandler(CommentException.class )
	public ResponseEntity<MyErrorDetail> myExceptionHandler(CommentException ip,WebRequest req){
		
		MyErrorDetail err =new MyErrorDetail();
		
		err.setTimestamp(LocalDateTime.now());
		err.setMessage(ip.getMessage());
		err.setDetails(req.getDescription(false));
		
		return new ResponseEntity<MyErrorDetail>(err,HttpStatus.BAD_REQUEST); 
	}
	
	@ExceptionHandler(NoHandlerFoundException.class)
	public ResponseEntity<MyErrorDetail> myNotFoundHandler(NoHandlerFoundException nfe,WebRequest req) {
		
		MyErrorDetail err =new MyErrorDetail();
		err.setTimestamp(LocalDateTime.now());
		err.setMessage(nfe.getMessage());
		err.setDetails(req.getDescription(false));
		
		return  new ResponseEntity<MyErrorDetail> (err,HttpStatus.BAD_REQUEST);  
		
	}
	
	
	@ExceptionHandler(Exception.class)
	public ResponseEntity<MyErrorDetail> pathNotFound(Exception ie ,WebRequest req){
		
		MyErrorDetail err= new MyErrorDetail();
		err.setTimestamp(LocalDateTime.now());
		err.setMessage(ie.getMessage());
		err.setDetails(req.getDescription(false));
		
		return new ResponseEntity<MyErrorDetail>(err,HttpStatus.BAD_REQUEST);
	}
	
	
	
	
}
