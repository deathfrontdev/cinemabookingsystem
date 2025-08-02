package com.example.cinemabooking.request;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Getter
@Setter
public class LoginRequest {

    @NotBlank(message = "Email is required")
    private String emailId;
    @NotBlank(message = "Password is required")
    private String password;
}