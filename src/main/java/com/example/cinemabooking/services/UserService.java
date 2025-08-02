package com.example.cinemabooking.services;

import com.example.cinemabooking.entities.User;
import com.example.cinemabooking.request.LoginRequest;
import com.example.cinemabooking.request.UserRequest;

public interface UserService {

    User login(LoginRequest authRequest);
    User register(UserRequest user);
}
