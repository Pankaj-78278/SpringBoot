package com.masai.service;

import java.util.List;

import com.masai.exception.AccountException;
import com.masai.exception.BankException;
import com.masai.exception.UserException;
import com.masai.model.Account;
import com.masai.model.Bank;
import com.masai.model.User;

public interface UserService {
	
	public User registerUser(User user) throws UserException;
	
	public List<User> UserSortedLList(String field, String order) throws UserException;
	
	
	public Bank registerBank(Bank bank) throws BankException;
	
	public Account openNewAccount(Integer bankId,Account acc) throws AccountException, BankException;
	
}
