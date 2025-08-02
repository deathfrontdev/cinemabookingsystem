package com.example.cinemabooking.repositories;

import com.example.cinemabooking.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Integer> {
    Optional<User> findByEmailId(String emailId);
    boolean existsByEmailId(String emailId);

}
