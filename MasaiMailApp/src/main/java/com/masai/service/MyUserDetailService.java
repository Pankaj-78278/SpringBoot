package com.masai.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.masai.repository.UserRepo;

public class MyUserDetailService {

	@Autowired
	private UserRepo urepo;
	
	@Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
		// TODO Auto-generated method stub
		
		User u=urepo.findByEmail(email);
		
		if(u!=null) {
			
			return new MyUserDetails(u);
		}
		else {
			throw new UsernameNotFoundException("No User Found");
		}
		
	}

}
