package com.instagramAPI.weeklytest.controller;

import com.instagramAPI.weeklytest.model.Post;
import com.instagramAPI.weeklytest.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/post")
public class PostController {
    @Autowired
    private PostService postService;

    //create post
    @PostMapping("/create-post")
    public ResponseEntity<?> createPost(@RequestBody Post post, @RequestParam String email){
        return postService.createPost(post,email);
    }

    //get all post
    @GetMapping("/get-post-by-id/{id}")
    public ResponseEntity<?> getPost(@PathVariable Integer id){
        return postService.getPost(id);
    }
}
