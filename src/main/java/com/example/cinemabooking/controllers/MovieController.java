package com.example.cinemabooking.controllers;

import com.example.cinemabooking.request.MovieRequest;
import com.example.cinemabooking.response.MovieResponse;
import com.example.cinemabooking.services.MovieService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/movie")
@RequiredArgsConstructor
public class MovieController {

    private final MovieService movieService;

    // Добавить фильм
    @PostMapping
    public ResponseEntity<MovieResponse> addMovie(@RequestBody MovieRequest movieRequest) {
        MovieResponse createdMovie = movieService.addMovie(movieRequest);
        return ResponseEntity.ok(createdMovie);
    }

    // Получить все фильмы
    @GetMapping
    public ResponseEntity<List<MovieResponse>> getAllMovies() {
        List<MovieResponse> movies = movieService.getAllMovies();
        return ResponseEntity.ok(movies);
    }

    // Обновить фильм
    @PutMapping("/{id}")
    public ResponseEntity<MovieResponse> updateMovie(@PathVariable Integer id,
                                                     @RequestBody MovieRequest movieRequest) {
        MovieResponse updatedMovie = movieService.updateMovie(id, movieRequest);
        return ResponseEntity.ok(updatedMovie);
    }

    // Удалить фильм
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteMovie(@PathVariable Integer id) {
        movieService.deleteMovie(id);
        return ResponseEntity.noContent().build();
    }

    // Получить фильм по ID
    @GetMapping("/{id}")
    public ResponseEntity<MovieResponse> getMovieById(@PathVariable Integer id) {
        MovieResponse movieResponse = movieService.getMovieById(id);
        return ResponseEntity.ok(movieResponse);
    }
}
