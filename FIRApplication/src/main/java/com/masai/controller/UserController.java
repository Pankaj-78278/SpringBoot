package com.masai.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


import com.masai.model.FIR;
import com.masai.model.User;
import com.masai.service.FIRService;
import com.masai.service.UserService;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

@RestController
public class UserController {

	@Autowired
	UserService userService;
	
	@Autowired
	FIRService firService;
	
	
	
	
	@PostMapping("/register")
	public ResponseEntity<Map<String, Object>> add_user(@RequestBody User user, HttpServletRequest request){
		Map<String, Object> response = userService.add_user(user);
		return new ResponseEntity<Map<String,Object>>(response, HttpStatus.ACCEPTED);
	}
	
	@PostMapping("/login")
	public ResponseEntity<Map<String, Object>> login_user(@RequestBody User user, HttpServletRequest request){

		Map<String, Object> response = userService.login_user(user);
		
		return new ResponseEntity<Map<String,Object>>(response, HttpStatus.ACCEPTED);
	}
	
	@PostMapping("/addfir")
	public ResponseEntity<Map<String, Object>> add_fir(@RequestBody FIR fir, HttpServletRequest request){

		Map<String, Object> response = firService.add_fir(fir);
		
		return new ResponseEntity<Map<String,Object>>(response, HttpStatus.ACCEPTED);
	}
	
}	
