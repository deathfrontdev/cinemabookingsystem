package com.example.cinemabooking.response;

import com.example.cinemabooking.enums.SeatType;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ShowSeatResponse {
    private Integer id;
    private String seatNo;
    private SeatType seatType;
    private Integer price;
    private Boolean isAvailable;
    private Boolean isFoodContains;
}
