package com.instagramAPI.weeklytest.repository;

import com.instagramAPI.weeklytest.model.Post;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IPostRepo extends JpaRepository<Post,Integer> {
}
