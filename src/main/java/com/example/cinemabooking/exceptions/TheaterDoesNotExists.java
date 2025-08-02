package com.example.cinemabooking.exceptions;

public class TheaterDoesNotExists extends RuntimeException {
    private static final long serialVersionUID = 2885350098352987873L;

    public TheaterDoesNotExists() {
        super("Theater does not Exists");
    }
}
