package com.masai.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface CurrentUserSessionDTO extends JpaRepository<CurrentUserSessionDTO, Integer>{
	  
	public CurrentUserSessionDTO findByUuid(String uuid);
}
