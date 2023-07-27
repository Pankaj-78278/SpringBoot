package com.ECom.repository.user;


import com.ECom.model.user.Orders;
import com.ECom.model.user.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserDao extends JpaRepository<User,Integer> {
    @Query("select c.orders from User c where c.userID=?1")
    public List<Orders> getAllOrderByCid(Integer userID);
    public User findByMob(String mobile);
}
