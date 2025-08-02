package com.example.cinemabooking.services.impl;

import com.example.cinemabooking.converter.MovieConvertor;
import com.example.cinemabooking.entities.Movie;
import com.example.cinemabooking.repositories.MovieRepository;
import com.example.cinemabooking.request.MovieRequest;
import com.example.cinemabooking.response.MovieResponse;
import com.example.cinemabooking.services.MovieService;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class MovieServiceImpl implements MovieService {

    private final MovieRepository movieRepository;
    private final MovieConvertor movieConvertor;

    @Override
    public MovieResponse addMovie(MovieRequest movieRequest) {
        Movie movie = movieConvertor.movieDtoToMovie(movieRequest);
        Movie saved = movieRepository.save(movie);
        return movieConvertor.toMovieResponse(saved);
    }

    @Override
    public List<MovieResponse> getAllMovies() {
        List<Movie> movies = movieRepository.findAll();
        return movies.stream()
                .map(movieConvertor::toMovieResponse)
                .collect(Collectors.toList());
    }

    @Override
    public MovieResponse getMovieById(Integer id) {
        return movieRepository.findById(id)
                .map(movieConvertor::toMovieResponse)
                .orElseThrow(() -> new EntityNotFoundException("Movie not found with id: " + id));
    }

    @Override
    public MovieResponse updateMovie(Integer id, MovieRequest movieRequest) {
        Movie existing = movieRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Movie not found with id: " + id));
        existing.setMovieName(movieRequest.getMovieName());
        existing.setDuration(movieRequest.getDuration());
        existing.setRating(movieRequest.getRating());
        existing.setReleaseDate(movieRequest.getReleaseDate());
        existing.setGenre(movieRequest.getGenre());
        existing.setLanguage(movieRequest.getLanguage());

        Movie updated = movieRepository.save(existing);
        return movieConvertor.toMovieResponse(updated);
    }

    @Override
    public void deleteMovie(Integer id) {
        movieRepository.deleteById(id);
    }
}
