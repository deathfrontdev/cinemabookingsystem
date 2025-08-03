package com.example.cinemabooking.converter;

import com.example.cinemabooking.entities.ShowSeat;
import com.example.cinemabooking.response.ShowSeatResponse;
import org.springframework.stereotype.Component;

@Component
public class ShowSeatConverter {
    public ShowSeatResponse convertToResponse(ShowSeat seat) {
        return ShowSeatResponse.builder()
                .id(seat.getId())
                .seatNo(seat.getSeatNo())
                .seatType(seat.getSeatType())
                .price(seat.getPrice())
                .isAvailable(seat.getIsAvailable())
                .isFoodContains(seat.getIsFoodContains())
                .build();
    }
}
