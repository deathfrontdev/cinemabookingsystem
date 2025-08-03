package com.example.cinemabooking.controllers;

import com.example.cinemabooking.entities.Show;
import com.example.cinemabooking.request.MovieRequest;
import com.example.cinemabooking.response.MovieResponse;
import com.example.cinemabooking.response.ShowResponse;
import com.example.cinemabooking.services.MovieService;
import com.example.cinemabooking.services.ShowService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/movie")
@RequiredArgsConstructor
public class MovieController {

    private final MovieService movieService;
    private final ShowService showService;

    @PostMapping
    public ResponseEntity<MovieResponse> addMovie(@RequestBody MovieRequest movieRequest) {
        MovieResponse createdMovie = movieService.addMovie(movieRequest);
        return ResponseEntity.ok(createdMovie);
    }

    @GetMapping
    public ResponseEntity<List<MovieResponse>> getAllMovies() {
        List<MovieResponse> movies = movieService.getAllMovies();
        return ResponseEntity.ok(movies);
    }

    @PutMapping("/{id}")
    public ResponseEntity<MovieResponse> updateMovie(@PathVariable Integer id,
                                                     @RequestBody MovieRequest movieRequest) {
        MovieResponse updatedMovie = movieService.updateMovie(id, movieRequest);
        return ResponseEntity.ok(updatedMovie);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteMovie(@PathVariable Integer id) {
        movieService.deleteMovie(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<MovieResponse> getMovieById(@PathVariable Integer id) {
        MovieResponse movieResponse = movieService.getMovieById(id);
        return ResponseEntity.ok(movieResponse);
    }

    // MovieController.java

    @GetMapping("/{id}/shows")
    public ResponseEntity<List<ShowResponse>> getShowsByMovieId(@PathVariable Integer id) {
        List<ShowResponse> shows = showService.getShowsByMovieId(id);
        return ResponseEntity.ok(shows);
    }

}
