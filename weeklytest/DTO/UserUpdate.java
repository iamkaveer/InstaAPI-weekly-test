package com.instagramAPI.weeklytest.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserUpdate {
    private String firstName;
    private String lastName;
    private Integer age;
    //private String email;
    private String phoneNumber;
    //private String userPassword;
}
