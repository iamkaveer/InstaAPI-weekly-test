package com.instagramAPI.weeklytest.model;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "tbl_user")
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, scope = User.class,property = "userId")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer userId;
    private String firstName;
    private String lastName;
    private Integer age;
    private String email;
    private String phoneNumber;
    private String userPassword;
    @OneToMany(mappedBy = "user")
    private List<Post> posts;

    public User(String firstName, String lastName, Integer age, String email, String phoneNumber, String encryptedPassword) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.userPassword = encryptedPassword;
    }
}
