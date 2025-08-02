package com.example.cinemabooking.converter;

import com.example.cinemabooking.entities.Movie;
import com.example.cinemabooking.request.MovieRequest;
import com.example.cinemabooking.response.MovieResponse;
import jakarta.persistence.Converter;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Component
public class MovieConvertor {
    
    public Movie movieDtoToMovie(MovieRequest movieRequest) {
        Movie movie = Movie.builder()
                .movieName(movieRequest.getMovieName())
                .duration(movieRequest.getDuration())
                .genre(movieRequest.getGenre())
                .language(movieRequest.getLanguage())
                .releaseDate(movieRequest.getReleaseDate())
                .rating(movieRequest.getRating())
                .build();

        return movie;
    }

    public MovieResponse toMovieResponse(Movie movie) {
        return MovieResponse.builder()
                .id(movie.getId())
                .movieName(movie.getMovieName())
                .duration(movie.getDuration())
                .rating(movie.getRating())
                .releaseDate(movie.getReleaseDate())
                .genre(movie.getGenre())
                .language(movie.getLanguage())
                .build();
    }

}
