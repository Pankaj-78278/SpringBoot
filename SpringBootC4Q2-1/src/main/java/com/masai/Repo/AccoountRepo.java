package com.masai.Repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.masai.model.Account;

@Repository
public interface AccoountRepo extends JpaRepository<Account, Integer> {


}
