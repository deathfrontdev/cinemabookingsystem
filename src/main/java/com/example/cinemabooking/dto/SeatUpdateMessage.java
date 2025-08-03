package com.example.cinemabooking.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SeatUpdateMessage {
    private Integer showId;
    private String seatNo;
    private boolean isAvailable;
}
