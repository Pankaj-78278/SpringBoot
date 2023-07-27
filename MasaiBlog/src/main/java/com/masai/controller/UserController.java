package com.masai.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.w3c.dom.events.EventException;

import com.masai.exception.LoginLogoutException;
import com.masai.exception.UserException;
import com.masai.model.User;
import com.masai.model.UserDTO;
import com.masai.service.UserService;

import antlr.debug.Event;

@RestController
public class UserController {

	@Autowired
	private UserService service;
	
	
	@PostMapping("user/register")
    public ResponseEntity<User> addAdmin(@RequestBody User user) throws UserException {

        User savedUser = service.registerUser(user);

        return new ResponseEntity<User>(savedUser, HttpStatus.CREATED);
    }

    @PostMapping("/user/login")
    public ResponseEntity<String> logInUser(@RequestBody UserDTO dto) throws LoginLogoutException {
        String result = service.loginAccount(dto);
        return new ResponseEntity<String>(result, HttpStatus.OK );
    }
    
    @GetMapping("/event/{type}")
	public ResponseEntity<List<Event>> getEventBytype(@PathVariable("type") String type) throws EventException{
		
		List<Event> submit= service.getEv;
		
		return new ResponseEntity<List<Event>>(submit,HttpStatus.OK);

	}
}
