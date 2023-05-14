package com.instagramAPI.weeklytest.model;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "tbl_post")
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, scope = Post.class,property = "postId")
public class Post {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer postId;
    private Timestamp createdDate;
    private Timestamp updatedDate;
    private String postData;
    @ManyToOne
    @JoinColumn(name = "user_fk")
    private User user;
}
