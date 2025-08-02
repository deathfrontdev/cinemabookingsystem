//package com.example.cinemabooking.controllers;
//
//import com.example.cinemabooking.converter.UserConvertor;
//import com.example.cinemabooking.entities.User;
//import com.example.cinemabooking.request.AuthRequest;
//import com.example.cinemabooking.request.UserRequest;
//import com.example.cinemabooking.response.UserResponse;
//import com.example.cinemabooking.security.JWTService;
//import com.example.cinemabooking.services.UserService;
//import lombok.RequiredArgsConstructor;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.*;
//
//import java.util.Map;
//
//@RestController
//@RequestMapping("/user")
//@RequiredArgsConstructor
//public class UserController {
//    private final UserService userService;
//    private final JWTService jwtService;
//
//    @PostMapping("/register")
//    public ResponseEntity<?> registerUser(@RequestBody UserRequest userRequest) {
//        User user = userService.register(userRequest);
//        String token = jwtService.generateToken(user.getEmailId());
//
//        UserResponse userResponse = UserConvertor.userToUserResponse(user);
//
//        return ResponseEntity.ok(Map.of(
//                "message", "User registered successfully",
//                "token", token,
//                "user", userResponse
//        ));
//    }
//
//    @PostMapping("/login")
//    public ResponseEntity<?> login(@RequestBody AuthRequest authRequest) {
//        User user = userService.login(authRequest);
//        String token = jwtService.generateToken(user.getEmailId());
//
//        UserResponse userResponse = UserConvertor.userToUserResponse(user);
//
//        return ResponseEntity.ok(Map.of(
//                "message", "Login successful",
//                "token", token,
//                "user", userResponse
//        ));
//    }
//
//}
