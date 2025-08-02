package com.example.cinemabooking.request;

import lombok.Data;

@Data
public class TheaterSeatRequest {
    private String address;
    private Integer noOfSeatInRow;
    private Integer noOfPremiumSeat;
    private Integer noOfClassicSeat;
}
