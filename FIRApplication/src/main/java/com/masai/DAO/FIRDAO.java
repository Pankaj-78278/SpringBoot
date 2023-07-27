package com.masai.DAO;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.masai.model.FIR;
import com.masai.model.User;

@Repository
public interface FIRDAO extends JpaRepository<FIR, Integer> {
	

	
	public List<FIR> getFIRById(Integer id);
	
}
