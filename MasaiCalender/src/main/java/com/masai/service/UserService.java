package com.masai.service;

import java.util.List;

import com.masai.exception.EventException;
import com.masai.exception.LoginException;
import com.masai.exception.UserException;
import com.masai.model.Event;
import com.masai.model.User;
import com.masai.model.UserDTO;


public interface UserService {
	
	public String loginAccount(UserDTO dto)throws LoginException;
	
	public User registerUser(User user)throws UserException;
	
	public User updateUser(User user)throws UserException;
	
//	public User loginUser(String email, String password)throws UserException;
	public List<Event> getEventByType(String type)throws EventException;

	
}
