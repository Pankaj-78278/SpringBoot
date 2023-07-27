package com.ECom.repository.user;

import com.ECom.model.user.Orders;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderDao extends JpaRepository<Orders,Integer> {
}
