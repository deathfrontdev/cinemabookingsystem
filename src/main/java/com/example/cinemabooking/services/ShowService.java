package com.example.cinemabooking.services;

import com.example.cinemabooking.exceptions.ShowDoesNotExists;
import com.example.cinemabooking.request.ShowRequest;
import com.example.cinemabooking.request.ShowSeatRequest;

public interface ShowService {
    String addShow(ShowRequest showRequest);
}
