package com.example.cinemabooking.services;

import com.example.cinemabooking.exceptions.ShowDoesNotExists;
import com.example.cinemabooking.request.ShowRequest;
import com.example.cinemabooking.request.ShowSeatRequest;
import com.example.cinemabooking.response.ShowResponse;

import java.util.List;

public interface ShowService {
    String addShow(ShowRequest showRequest);

    List<ShowResponse> getShowsByMovieId(Integer id);
}
