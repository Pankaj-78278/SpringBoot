package com.masai.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import com.masai.model.User;
import com.masai.repository.UserRepo;

@Component
public class GetCurrentUser {

	
	@Autowired
	private UserRepo urepo;
	
	public User getLoggedInUserDetails() {
		
		
		SecurityContext sc =SecurityContextHolder.getContext();
		
		
		Authentication auth=sc.getAuthentication();
		
		return urepo.findByEmail(auth.getName());
	}
}
