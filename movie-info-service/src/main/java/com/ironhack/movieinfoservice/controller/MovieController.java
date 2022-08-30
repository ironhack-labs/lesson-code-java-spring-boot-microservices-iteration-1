package com.ironhack.movieinfoservice.controller;

import com.ironhack.movieinfoservice.model.Movie;
import com.ironhack.movieinfoservice.repository.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

@RestController
@RequestMapping("/api")
public class MovieController {

    @Autowired
    public MovieRepository movieRepository;

    @GetMapping("/movies/{movieId}")
    @ResponseStatus(HttpStatus.OK)
    public Movie getMovieInfo(@PathVariable String movieId) {
        return movieRepository.findById(movieId).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Movie not found"));
    }
}
