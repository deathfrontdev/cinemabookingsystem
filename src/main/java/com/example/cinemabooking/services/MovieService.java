package com.example.cinemabooking.services;

import com.example.cinemabooking.request.MovieRequest;
import com.example.cinemabooking.response.MovieResponse;

import java.util.List;

public interface MovieService {
    MovieResponse addMovie(MovieRequest movieRequest);
    List<MovieResponse> getAllMovies();
    MovieResponse getMovieById(Integer id);
    MovieResponse updateMovie(Integer id, MovieRequest movieRequest);
    void deleteMovie(Integer id);
}
