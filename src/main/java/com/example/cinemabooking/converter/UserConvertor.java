package com.example.cinemabooking.converter;

import com.example.cinemabooking.entities.User;
import com.example.cinemabooking.enums.Role;
import com.example.cinemabooking.request.UserRequest;
import com.example.cinemabooking.response.UserResponse;

public class UserConvertor {

    public static User userDtoToUser(UserRequest userRequest, String encodedPassword) {
        return User.builder()
                .name(userRequest.getName())
                .age(userRequest.getAge())
                .address(userRequest.getAddress())
                .gender(userRequest.getGender())
                .mobileNo(userRequest.getMobileNo())
                .emailId(userRequest.getEmailId())
                .password(encodedPassword)
                .role(userRequest.getRole() != null ? userRequest.getRole() : Role.ROLE_USER)
                .build();
    }

    public static UserResponse userToUserResponse(User user) {
        return UserResponse.builder()
                .id(user.getId())
                .name(user.getName())
                .age(user.getAge())
                .address(user.getAddress())
                .gender(user.getGender())
                .mobileNo(user.getMobileNo())
                .emailId(user.getEmailId())
                .role(user.getRole()) // ✅ исправлено
                .build();
    }
}
