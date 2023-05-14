package com.instagramAPI.weeklytest.repository;

import com.instagramAPI.weeklytest.model.AuthenticationToken;
import com.instagramAPI.weeklytest.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ITokenRepo extends JpaRepository<AuthenticationToken,Long> {
    AuthenticationToken findByUser(User user);
}
