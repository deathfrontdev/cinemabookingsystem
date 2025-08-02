package com.example.cinemabooking.request;


import com.example.cinemabooking.enums.Gender;
import com.example.cinemabooking.enums.Role;
import lombok.Data;

@Data
public class UserRequest {

    private String name;
    private Integer age;
    private String address;
    private String mobileNo;
    private String emailId;
    private String password;
    private Gender gender;
    private Role role;
}
