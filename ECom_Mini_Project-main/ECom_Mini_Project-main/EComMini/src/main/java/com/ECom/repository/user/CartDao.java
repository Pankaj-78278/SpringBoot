package com.ECom.repository.user;

import com.ECom.model.user.Cart;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CartDao extends JpaRepository<Cart,Integer> {
}
