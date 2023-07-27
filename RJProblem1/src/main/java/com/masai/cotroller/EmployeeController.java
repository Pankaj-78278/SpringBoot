package com.masai.cotroller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;

import com.masai.model.Employee;
import com.masai.repository.EmployeeRepo;

import io.swagger.v3.oas.annotations.parameters.RequestBody;

public class EmployeeController {

	@Autowired
	private EmployeeRepo repo;
	
	@Autowired
	private PasswordEncoder passwordEncoder;

	
	@GetMapping("/register")
	public ResponseEntity<Employee> addEmployee(@RequestBody Employee employee){
		employee.setPassword(passwordEncoder.encode(employee.getPassword()));
		
		Employee emp= repo.save(employee);
		
		return new ResponseEntity<Employee>(emp,HttpStatus.OK);
	}
	
	@GetMapping("/admin")
	public ResponseEntity<String> admin(){
		
		return  new ResponseEntity<String>("Welcome to the masai App for the Admin", HttpStatus.ACCEPTED);
	}
	
}
