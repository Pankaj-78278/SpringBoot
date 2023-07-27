package com.masai.DAO;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.masai.model.CurrentSession;

import jakarta.persistence.Id;

@Repository
public interface UserSessionDao extends JpaRepository<Id, Integer> {
	
	public CurrentSession findByUniqueId(Integer Id);
}
