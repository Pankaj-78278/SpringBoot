package com.masai.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.masai.model.CurrentSessionDTO;

@Repository  
public interface SessionRepo extends JpaRepository<CurrentSessionDTO, Integer> {

	public CurrentSessionDTO findByUuid(String uuid);
	
}
