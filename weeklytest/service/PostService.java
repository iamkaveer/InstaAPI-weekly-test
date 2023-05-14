package com.instagramAPI.weeklytest.service;

import com.instagramAPI.weeklytest.DTO.ErrorResponse;
import com.instagramAPI.weeklytest.DTO.SignUpOutput;
import com.instagramAPI.weeklytest.DTO.SuccessResponse;
import com.instagramAPI.weeklytest.model.Post;
import com.instagramAPI.weeklytest.model.User;
import com.instagramAPI.weeklytest.repository.IPostRepo;
import com.instagramAPI.weeklytest.repository.IUserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PostService {
    @Autowired
    private IPostRepo iPostRepo;
    @Autowired
    private IUserRepo iUserRepo;
    @Autowired
    private AuthenticationService authenticationService;
    public ResponseEntity<?> createPost(Post newPost, String email) {
        User existUser = iUserRepo.findUserByEmail(email);
        if(existUser == null){
            //throw new IllegalStateException("User with this email already exist..try sign-in");
            ErrorResponse errorResponse = new ErrorResponse("please provide valid email id..!!");
            return ResponseEntity.status(HttpStatus.CONFLICT).body(errorResponse);
        }
        newPost.setUser(existUser);
        iPostRepo.save(newPost);
        SuccessResponse successResponse = new SuccessResponse("post created..!!");
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(successResponse);
    }

    public ResponseEntity<?> getPost(Integer id) {
        Post existPost = iPostRepo.findById(id).get();
        if(existPost == null){
            ErrorResponse errorResponse = new ErrorResponse("Post does not exist..!!");
            return ResponseEntity.status(HttpStatus.CONFLICT).body(errorResponse);
        }
        return ResponseEntity.ok(existPost);
    }
}
