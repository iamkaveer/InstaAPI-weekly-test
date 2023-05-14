package com.instagramAPI.weeklytest.service;

import com.instagramAPI.weeklytest.model.AuthenticationToken;
import com.instagramAPI.weeklytest.model.User;
import com.instagramAPI.weeklytest.repository.ITokenRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AuthenticationService {
    @Autowired
    private ITokenRepo iTokenRepo;

    //save token
    public void saveToken(AuthenticationToken token){
        iTokenRepo.save(token);
    }

    //get token
    public AuthenticationToken getToken(User user){
        return iTokenRepo.findByUser(user);
    }
}
