package com.masai.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface CurrentUserSessionRepo extends JpaRepository<CurrentUserSessionRepo, Integer>{
	  
	public CurrentUserSessionRepo findByUuid(String uuid);
}
