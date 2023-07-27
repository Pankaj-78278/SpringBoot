package com.masai.configuration;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.masai.model.Employee;
import com.masai.model.MyUserDetail;
import com.masai.repository.EmployeeRepo;

@Service
public class MyUserDetailService implements UserDetailsService {
	
	@Autowired
	private EmployeeRepo erepo;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		// TODO Auto-generated method stub
	
		Optional<Employee> optEmp=erepo.findByUserName(username);
		if(optEmp.isPresent()) {
			return new MyUserDetail(optEmp.get());
		}else {
			throw new UsernameNotFoundException("Username is not found  ");
		}
	
	}
	
	
	
}
