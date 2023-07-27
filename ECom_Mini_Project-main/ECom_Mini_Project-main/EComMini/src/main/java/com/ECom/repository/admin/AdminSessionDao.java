package com.ECom.repository.admin;

import com.ECom.model.admin.CurrentAdminSession;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


public interface AdminSessionDao extends JpaRepository<CurrentAdminSession ,Integer> {
    public CurrentAdminSession findByUuid(String uuid);
}
