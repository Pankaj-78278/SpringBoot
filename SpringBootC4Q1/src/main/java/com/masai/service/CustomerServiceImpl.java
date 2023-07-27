package com.masai.service;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.masai.exception.CustomerException;
import com.masai.model.Customer;
import com.masai.model.CustomerDTO;
import com.masai.repo.CustomerRepo;

@Service
public class CustomerServiceImpl implements CustomerService {

	@Autowired
	private CustomerRepo repo;
	
	@Override
	public Customer registerCustomer(Customer customer) throws CustomerException {
		
		Customer cus=repo.save(customer);
		
		return cus;
	}

	@Override
	public Customer getCustomerById(Integer customerId) throws CustomerException {
		Optional<Customer> cus=repo.findById(customerId);
		if(cus.isPresent()) {
			Customer customer=cus.get();
			return customer;
		}else {
			throw new CustomerException("Customer id is not present:"+ customerId);
		}
		
	}

//	@Override
//	public Customer loginCustomer(String email, String password) {
//		// TODO Auto-generated method stub
//		return null;
//	}

//	@Override
//	public Customer updateCustomerPassword(String username, String oldPassword, String newPassword)throws CustomerException {
	
//		Optional<Customer> updateCus=repo.findAll(oldPassword);
//		
//		if(updateCus.isPresent()) {
//			Customer cus= repo.save(newPassword );
//			return cus;
//		}else {
//			throw new CustomerException("Customer table  is Empty ");
//		}
//		return null;
//	}

	@Override
	public List<Customer> getAllCustomerDetails() throws CustomerException {
			
		List<Customer> custo= repo.findAll();
		
		if(custo.size()==0) {
			throw new CustomerException("Customer is not present");
		}else {
			return custo;
		}
	}

	@Override
	public Customer deleteCustomerById(Integer customerId) throws CustomerException {
		
		Customer del	=repo.findById(customerId).orElseThrow(() ->new CustomerException("Customer is not present"));
		repo.delete(del);
		return del;
				
			
	}

	@Override
	public List<Customer> getCustomerDetailsByAddress(String address) throws CustomerException {
		List<Customer> res= repo.findByAddress(address);
		if(res!=null) {
			return res;
		}else {
			throw new CustomerException("customer is not found by address"+res );
		}
	}

	@Override
	public Customer updateCustomer(Customer customer) throws CustomerException {
	Optional<Customer> updateCus	=repo.findById(customer.getCustomerId());
	
		if(updateCus.isPresent()) {
			Customer cus= repo.save(customer);
			return cus;
		}else {
			throw new CustomerException("Customer table  is Empty ");
		}
	}

	@Override
	public List<CustomerDTO> getNameAddressAgeOfAllCustomers() throws CustomerException {
		
		List<CustomerDTO> custodto=repo.allListNameAge();
		
		if(custodto!=null) {
			return  custodto;
		}else {
			throw new CustomerException("customer is not found in customer table");
		}
			
	}


}
