package com.example.cinemabooking.request;

import com.example.cinemabooking.enums.Genre;
import com.example.cinemabooking.enums.Language;
import lombok.Data;

import java.sql.Date;

@Data
public class MovieRequest {
    private String movieName;
    private Integer duration;
    private Double rating;
    private Date releaseDate;
    private Genre genre;
    private Language language;
}
