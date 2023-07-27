package com.masai.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.masai.model.User;

@RestController
@RequestMapping("/masaimail")
public class UserController {
	
	@PostMapping("/register")
	public ResponseEntity<User> registerUser( ){
		
	}
	
}
