package com.ECom.repository.user;


import com.ECom.model.user.CurrentUserSession;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserSessionDao extends JpaRepository<CurrentUserSession,Integer> {
    public CurrentUserSession findByUnqID(String unqID);
}
