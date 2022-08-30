package com.ironhack.moviecatalogservice.controller;

import com.ironhack.moviecatalogservice.model.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api")
public class CatalogController {

    @Autowired
    private RestTemplate restTemplate;

    @GetMapping("/catalogs/user/{userId}")
    @ResponseStatus(HttpStatus.OK)
    public Catalog getCatalog(@PathVariable int userId) {

        User user = restTemplate.getForObject("http://localhost:8083/api/users/" + userId, User.class);
        UserRating userRatings = restTemplate.getForObject("http://localhost:8083/api/users/" + userId + "/ratings", UserRating.class);

        Catalog catalog = new Catalog();
        catalog.setUsername(user.getUsername());
        List<MovieRating> movieRatings = new ArrayList<>();

        //Loop over all user ratings and get the movie information for each rating
        for (Rating rating : userRatings.getRatings()) {
            Movie movie = restTemplate.getForObject("http://localhost:8082/api/movies/" + rating.getMovieId(), Movie.class);
            movieRatings.add(new MovieRating(movie.getName(), movie.getDescription(), rating.getRating()));
        }

        catalog.setMovieRatings(movieRatings);
        return catalog;
    }
}
