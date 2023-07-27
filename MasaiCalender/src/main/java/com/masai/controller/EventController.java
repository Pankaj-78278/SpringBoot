package com.masai.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.masai.exception.EventException;
import com.masai.model.Event;
import com.masai.service.EventService;
@RestController
@RequestMapping("/masaicalender")
public class EventController {
	
		
		@Autowired
		private EventService service;
		
		
		@PostMapping("/event")
		public ResponseEntity<Event> createEven(@RequestBody Event  event,@RequestParam String email) throws EventException{
			
			Event e = service.registerEvent(event,email);		
			return new ResponseEntity<Event>(e,HttpStatus.CREATED);

		}
		
		@PutMapping("/event/{id}")
		public ResponseEntity<Event> updateEven(@PathVariable("id") Integer id,@RequestBody Event event) throws EventException{
			
		     Event updatedevent = 	service.updateEven(id, event);
		     
			
		     return new ResponseEntity<Event>(updatedevent,HttpStatus.OK);
			
		}
		
		@DeleteMapping("/event/{id}")
		public ResponseEntity<Event> deleteEven(@PathVariable("id") Integer id) throws EventException{
			
		     Event deletedevent = 	service.deleteEven(id);
		     
			
		     return new ResponseEntity<Event>(deletedevent,HttpStatus.OK);
			
		}

	}
	

