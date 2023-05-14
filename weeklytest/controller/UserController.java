package com.instagramAPI.weeklytest.controller;

import com.instagramAPI.weeklytest.DTO.*;
import com.instagramAPI.weeklytest.service.AuthenticationService;
import com.instagramAPI.weeklytest.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;

    @Autowired
    private AuthenticationService authenticationService;

    //user sign up
    @PostMapping("/sign-up")
    public ResponseEntity<?> signup(@RequestBody SignUpInput signUpInput){
        return userService.signUp(signUpInput);
    }

    //user sign in
    @PostMapping("/sign-in")
    public ResponseEntity<?> signIn(@RequestBody SignInInput signInInput){
        return userService.signIn(signInInput);
    }

    //update user
    @PutMapping("/update-user")
    public ResponseEntity<?> updateUser(@RequestBody UserUpdate userUpdate,@RequestParam String email){
        return userService.updateUser(userUpdate,email);
    }
}
