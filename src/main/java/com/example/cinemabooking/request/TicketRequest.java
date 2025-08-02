package com.example.cinemabooking.request;

import lombok.Data;

import java.util.List;

@Data
public class TicketRequest {
    private Integer showId;
    private Integer userId;
    private List<String> requestSeats;
}
