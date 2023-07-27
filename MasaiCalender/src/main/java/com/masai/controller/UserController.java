package com.masai.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.masai.exception.EventException;
import com.masai.exception.UserException;
import com.masai.model.Event;
import com.masai.model.User;
import com.masai.service.UserService;


@RestController
@RequestMapping("/masaicalender")
public class UserController {
	@Autowired
	private UserService service;
	
	@PostMapping("/register")
	public ResponseEntity<User> registerAccount(@Valid @RequestBody User use) throws UserException{
		
		User res=service.registerUser(use);
		return new ResponseEntity<User>(res,HttpStatus.CREATED);	
	}
	

	@PutMapping("/user")
	public ResponseEntity<User> updateCustomerDetail(@RequestBody User use) throws UserException{
		
		User result=service.updateUser(use);
		
		return new ResponseEntity<User>(result,HttpStatus.OK);
	}
	
	@GetMapping("/event/{type}")
	public ResponseEntity<List<Event>> getEventType(@PathVariable("type") String type)throws  EventException{
		
		List<Event> userlist = service.getEventByType(type);
		
		return new ResponseEntity<List<Event>>(userlist,HttpStatus.OK);

	}
}
