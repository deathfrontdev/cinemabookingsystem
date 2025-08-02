package com.example.cinemabooking.controllers;

import com.example.cinemabooking.converter.UserConvertor;
import com.example.cinemabooking.entities.User;
import com.example.cinemabooking.request.AuthRequest;
import com.example.cinemabooking.request.LoginRequest;
import com.example.cinemabooking.request.UserRequest;
import com.example.cinemabooking.response.UserResponse;
import com.example.cinemabooking.security.JWTService;
import com.example.cinemabooking.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    private UserService userService;
    @Autowired
    private JWTService  jwtService;

    @PostMapping("/register")
    public ResponseEntity<?> registerUser(@RequestBody UserRequest userRequest) {
        User user = userService.register(userRequest);
        String token = jwtService.generateToken(user.getEmailId());

        UserResponse userResponse = UserConvertor.userToUserResponse(user);

        return ResponseEntity.ok(Map.of(
                "message", "User registered successfully",
                "token", token,
                "user", userResponse
        ));
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody LoginRequest loginRequest) {
        User user = userService.login(loginRequest);
        String token = jwtService.generateToken(user.getEmailId());

        UserResponse userResponse = UserConvertor.userToUserResponse(user);

        return ResponseEntity.ok(Map.of(
                "message", "Login successful",
                "token", token,
                "user", userResponse
        ));
    }

}