package com.ECom.repository.admin;

import com.ECom.model.admin.Admin;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AdminDao extends JpaRepository<Admin,Integer> {
    public Admin findByMobileNumber(String mobile);
}
