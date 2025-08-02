package com.example.cinemabooking.response;

import com.example.cinemabooking.enums.Gender;
import com.example.cinemabooking.enums.Role;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class UserResponse {
    private Integer id;
    private String name;
    private Integer age;
    private String address;
    private Gender gender;
    private String mobileNo;
    private String emailId;
    private Role role;
}
