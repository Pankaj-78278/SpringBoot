package com.masai.service;


import com.masai.exception.LoginLogoutException;
import com.masai.exception.UserException;
import com.masai.model.User;
import com.masai.model.UserDTO;

public interface UserService {
	
	public User registerUser(User user) throws UserException;
	
	public String loginAccount(UserDTO dto)throws LoginLogoutException;
	
}
