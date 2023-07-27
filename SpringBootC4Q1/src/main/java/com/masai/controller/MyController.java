package com.masai.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.masai.exception.CustomerException;
import com.masai.model.Customer;
import com.masai.model.CustomerDTO;
import com.masai.service.CustomerService;

@RestController
public class MyController  {
	
	@Autowired
	private CustomerService service;
	
		
	@PostMapping("/customers")
	public ResponseEntity<Customer> saveCustomer(@Valid @RequestBody Customer customer) throws CustomerException{
		
		Customer res=service.registerCustomer(customer);
		return new ResponseEntity<Customer>(res,HttpStatus.CREATED);
	}
	
	@GetMapping("/customers/{id}")
	public ResponseEntity<Customer> getCustomerByIdHandler(@PathVariable("id") Integer customerId) throws CustomerException{
		
	Customer res=	service.getCustomerById(customerId);
		
	return new ResponseEntity<Customer>(res,HttpStatus.ACCEPTED);
		
	}
	
	
	@GetMapping("/customers")
	public ResponseEntity<List<Customer>> getAllCustomerHandler(Customer customer) throws CustomerException{
		
		List<Customer> res=service.getAllCustomerDetails();
		
		return new ResponseEntity<List<Customer>>(res,HttpStatus.OK);
	}
	
	@DeleteMapping("/customers")
	public ResponseEntity<Customer> delCustomerByIdHandler(Integer customerId) throws CustomerException{
		
		Customer result=service.deleteCustomerById(customerId);
		
		return new ResponseEntity<Customer>(result,HttpStatus.ACCEPTED);
	}
	
	
	
	
	@GetMapping("/customersbyadd/{add}")
	public ResponseEntity<List<Customer>> getDetailsByAddressHandler(@PathVariable("add") String address) throws CustomerException{
		List<Customer> addresult=service.getCustomerDetailsByAddress(address);
		
		return new ResponseEntity<List<Customer>>(addresult,HttpStatus.OK);
		
	}
	
	
	@PutMapping("/customers")
	public ResponseEntity<Customer> updateCustomerDetailHandler(@RequestBody Customer customer) throws CustomerException{
		
		Customer result=service.updateCustomer(customer);
		
		return new ResponseEntity<Customer>(result,HttpStatus.OK);
	}
	
	
	@GetMapping("/getallcustomers")
	public ResponseEntity<List<CustomerDTO>> getCustomerDtoHandler(CustomerDTO customer) throws CustomerException{
		
		List<CustomerDTO> result=service.getNameAddressAgeOfAllCustomers();
	
		return new ResponseEntity<List<CustomerDTO>>(result,HttpStatus.ACCEPTED);
		
	}
	
}
