package com.masai.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.masai.model.Customer;
import com.masai.model.CustomerDTO;

@Repository
public interface CustomerRepo extends JpaRepository<Customer, Integer> {
	
	public List<Customer> findByAddress(String address);
	
	@Query("select new com.masai.model.CustomerDTO(s.name,s.address,s.age) from Customer s")
	public List<CustomerDTO> allListNameAge();

	
}
