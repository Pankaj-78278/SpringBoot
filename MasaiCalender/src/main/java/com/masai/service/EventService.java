package com.masai.service;

import com.masai.exception.EventException;
import com.masai.model.Event;

public interface EventService {
	
	public Event registerEvent(Event event,String email)throws EventException;
	
	public Event updateEven(Integer id,Event event) throws EventException;
	
	public Event deleteEven(Integer id)throws EventException;
	
	
}
