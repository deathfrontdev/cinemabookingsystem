package com.example.cinemabooking.services.impl;

import com.example.cinemabooking.converter.ShowSeatConverter;
import com.example.cinemabooking.entities.ShowSeat;
import com.example.cinemabooking.repositories.ShowSeatRepository;
import com.example.cinemabooking.response.ShowSeatResponse;
import com.example.cinemabooking.services.ShowSeatService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ShowSeatServiceImpl implements ShowSeatService {

    private final ShowSeatRepository showSeatRepository;
    private final ShowSeatConverter showSeatConverter;

    @Override
    public List<ShowSeatResponse> getAvailableSeatsByShow(Integer showId) {
        List<ShowSeat> availableSeats = showSeatRepository.findByShow_ShowIdAndIsAvailableTrue(showId);

        return availableSeats.stream()
                .map(showSeatConverter::convertToResponse)
                .collect(Collectors.toList());
    }
}
