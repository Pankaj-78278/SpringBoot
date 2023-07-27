package com.masai.service;

import com.masai.exception.LoginException;
import com.masai.exception.UserException;
import com.masai.model.LoginDTO;
import com.masai.model.User;

public interface UserService {
	
	public User registerUser(User user) throws UserException;
	
	public String logIn(LoginDTO dto) throws LoginException;
	
	public String logOut(String uId) throws LoginException;
	
}
