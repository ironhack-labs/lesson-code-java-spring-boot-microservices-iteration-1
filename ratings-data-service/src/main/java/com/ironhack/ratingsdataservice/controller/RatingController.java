package com.ironhack.ratingsdataservice.controller;

import com.ironhack.ratingsdataservice.model.Rating;
import com.ironhack.ratingsdataservice.repository.RatingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class RatingController {

    @Autowired
    RatingRepository ratingRepository;

    @GetMapping("/ratings")
    @ResponseStatus(HttpStatus.OK)
    public List<Rating> getRatings(@RequestParam Optional<String> movieId) {
        if (movieId.isPresent()) {
            return ratingRepository.findByMovieId(movieId.orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Wrong movie id")));
        }
        return ratingRepository.findAll();
    }
}
