package com.example.cinemabooking.converter;

import com.example.cinemabooking.entities.Show;
import com.example.cinemabooking.request.ShowRequest;

public class ShowConvertor {

    public static Show showDtoToShow(ShowRequest showRequest) {
        Show show = Show.builder()
                .time(showRequest.getShowStartTime())
                .date(showRequest.getShowDate())
                .build();

        return show;
    }
}
