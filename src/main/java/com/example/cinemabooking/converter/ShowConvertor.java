package com.example.cinemabooking.converter;

import com.example.cinemabooking.entities.Show;
import com.example.cinemabooking.request.ShowRequest;
import org.springframework.stereotype.Component;

import java.util.ArrayList;

@Component
public class ShowConvertor {

    public static Show showDtoToShow(ShowRequest showRequest) {
            return Show.builder()
                    .time(showRequest.getShowStartTime())
                    .date(showRequest.getShowDate())
                    .showSeatList(new ArrayList<>()) // ✅ добавляем инициализацию
                    .build();
        }
}
