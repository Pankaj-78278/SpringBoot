package com.masai.cotroller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/masai")
public class UserController {
	
	@GetMapping("/welcome")
	public ResponseEntity<String> printWelcome(){
		
		return new ResponseEntity<String>("Welcome to the masai App without security", HttpStatus.ACCEPTED);
	}
	
	@GetMapping("/security")
	public ResponseEntity<String> printSomething(){
		
		return new ResponseEntity<String>("welcome to the masai App with security",HttpStatus.ACCEPTED);
	}
}
