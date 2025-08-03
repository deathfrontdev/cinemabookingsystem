package com.example.cinemabooking.services;

import com.example.cinemabooking.response.ShowSeatResponse;

import java.util.List;

public interface ShowSeatService {
    List<ShowSeatResponse> getAvailableSeatsByShow(Integer showId);
}
