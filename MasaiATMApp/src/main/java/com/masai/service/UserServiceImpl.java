package com.masai.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.masai.exception.AccountException;
import com.masai.exception.BankException;
import com.masai.exception.UserException;
import com.masai.model.Account;
import com.masai.model.Bank;
import com.masai.model.User;

@Service
public class UserServiceImpl implements UserService {
	
	

	@Override
	public User registerUser(User user) throws UserException {
		
		
	}

	@Override
	public List<User> UserSortedLList(String field, String order) throws UserException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Bank registerBank(Bank bank) throws BankException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Account openNewAccount(Integer bankId, Account acc) throws AccountException, BankException {
		// TODO Auto-generated method stub
		return null;
	}

	
	
}
