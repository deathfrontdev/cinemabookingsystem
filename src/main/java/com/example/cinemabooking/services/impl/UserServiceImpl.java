package com.example.cinemabooking.services.impl;

import com.example.cinemabooking.converter.UserConvertor;
import com.example.cinemabooking.entities.User;
import com.example.cinemabooking.exceptions.UserExist;
import com.example.cinemabooking.repositories.UserRepository;
import com.example.cinemabooking.request.LoginRequest;
import com.example.cinemabooking.request.UserRequest;
import com.example.cinemabooking.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public User register(UserRequest userRequest) {
        Optional<User> users = userRepository.findByEmailId(userRequest.getEmailId());

        if (users.isPresent()) {
            throw new UserExist();
        }

        User user = UserConvertor.userDtoToUser(userRequest, passwordEncoder.encode(userRequest.getPassword()));
        return userRepository.save(user);
    }

    @Override
    public User login(LoginRequest loginRequest) {
        Optional<User> userOptional = userRepository.findByEmailId(loginRequest.getEmailId());

        if (userOptional.isEmpty()) {
            throw new RuntimeException("Пользователь с таким email не найден");
        }

        User user = userOptional.get();

        boolean isPasswordMatch = passwordEncoder.matches(loginRequest.getPassword(), user.getPassword());

        if (!isPasswordMatch) {
            throw new RuntimeException("Неверный пароль");
        }

        return user;
    }



}