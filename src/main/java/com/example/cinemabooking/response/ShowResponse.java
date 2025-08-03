package com.example.cinemabooking.response;

import lombok.Builder;
import lombok.Data;

import java.sql.Date;
import java.sql.Time;

@Data
@Builder
public class ShowResponse {

    private Integer showId;
    private Date date;
    private Time time;
    private String theaterName;
    private String movieTitle;
}
