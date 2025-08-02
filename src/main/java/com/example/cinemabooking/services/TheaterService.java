package com.example.cinemabooking.services;

import com.example.cinemabooking.exceptions.TheaterIsExist;
import com.example.cinemabooking.exceptions.TheaterIsNotExist;
import com.example.cinemabooking.request.TheaterRequest;
import com.example.cinemabooking.request.TheaterSeatRequest;

public interface TheaterService {

    String addTheater(TheaterRequest theaterRequest) throws TheaterIsExist;

    String addTheaterSeat(TheaterSeatRequest entryDto) throws TheaterIsNotExist;
}
