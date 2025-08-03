package com.example.cinemabooking.controllers;

import com.example.cinemabooking.response.ShowSeatResponse;
import com.example.cinemabooking.services.ShowSeatService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
@RestController
@RequestMapping("/show-seat")
@RequiredArgsConstructor
public class ShowSeatController {

    private final ShowSeatService showSeatService;

    @GetMapping("/{showId}/seats")
    public ResponseEntity<List<ShowSeatResponse>> getAvailableSeats(@PathVariable Integer showId) {
        return ResponseEntity.ok(showSeatService.getAvailableSeatsByShow(showId));
    }
}

