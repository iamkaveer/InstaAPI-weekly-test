package com.instagramAPI.weeklytest.service;

import com.instagramAPI.weeklytest.DTO.*;
import com.instagramAPI.weeklytest.model.AuthenticationToken;
import com.instagramAPI.weeklytest.model.User;
import com.instagramAPI.weeklytest.repository.IUserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.util.DigestUtils;

@Service
public class UserService {
    @Autowired
    private IUserRepo iUserRepo;

    @Autowired
    private AuthenticationService authenticationService;

    //user registration
    public ResponseEntity<?> signUp(SignUpInput signUpInput){
        //check if user exist or not
        User existUser = iUserRepo.findUserByEmail(signUpInput.getEmail());
        if(existUser != null){
            //throw new IllegalStateException("User with this email already exist..try sign-in");
            ErrorResponse errorResponse = new ErrorResponse("User with this email already exist..try sign-in!!");
            return ResponseEntity.status(HttpStatus.CONFLICT).body(errorResponse);
        }
        String encryptedPassword = DigestUtils.md5DigestAsHex(signUpInput.getUserPassword().getBytes());
        User newUser = new User(
                signUpInput.getFirstName(),
                signUpInput.getLastName(),
                signUpInput.getAge(),
                signUpInput.getEmail(),
                signUpInput.getPhoneNumber(),
                encryptedPassword
        );
        //save user to db
        iUserRepo.save(newUser);

        //create and save token
        AuthenticationToken token = new AuthenticationToken(newUser);
        authenticationService.saveToken(token);
        return new ResponseEntity<>(new SignUpOutput("User registered successfully..!!"), HttpStatus.OK);
    }

    //user sign in
    public ResponseEntity<?> signIn(SignInInput signInInput){
        //check user present or not in database
        User existUser = iUserRepo.findUserByEmail(signInInput.getUserEmail());
        if(existUser == null){
            //email not present
            //throw new IllegalStateException("No User is registered with this email..try sign-up!!");
            ErrorResponse errorResponse = new ErrorResponse("No User is registered with this email..try sign-up!!");
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(errorResponse);
        }
        String encryptedPassword = DigestUtils.md5DigestAsHex(signInInput.getUserPassword().getBytes());
        boolean isValidPassword = encryptedPassword.equals(existUser.getUserPassword());
        if(!isValidPassword){
            ErrorResponse errorResponse = new ErrorResponse("Invalid Password");
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(errorResponse);
        }
        AuthenticationToken authenticationToken = authenticationService.getToken(existUser);

        return new ResponseEntity<>(new SignInOutput(authenticationToken.getToken()), HttpStatus.ACCEPTED);
    }

    //update user
    public ResponseEntity<?> updateUser(UserUpdate userUpdate, String email) {
        User existUser = iUserRepo.findUserByEmail(email);
        if(existUser != null){
            existUser.setFirstName(userUpdate.getFirstName());
            existUser.setLastName(userUpdate.getLastName());
            existUser.setAge(userUpdate.getAge());
            existUser.setPhoneNumber(userUpdate.getPhoneNumber());
            iUserRepo.save(existUser);
            return ResponseEntity.status(HttpStatus.ACCEPTED).body("UPDATED");
        }else {
            ErrorResponse errorResponse = new ErrorResponse("No User is registered with this email.");
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(errorResponse);
        }
    }



}
