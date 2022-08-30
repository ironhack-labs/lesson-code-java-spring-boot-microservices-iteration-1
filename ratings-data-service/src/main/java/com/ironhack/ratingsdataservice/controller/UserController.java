package com.ironhack.ratingsdataservice.controller;

import com.ironhack.ratingsdataservice.model.User;
import com.ironhack.ratingsdataservice.DTO.UserRating;
import com.ironhack.ratingsdataservice.repository.UserRepository;
import com.ironhack.ratingsdataservice.service.interfaces.UserServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

//import javax.ws.rs.Path;


@RestController
@RequestMapping("/api")
public class UserController {
    @Autowired
    UserServiceInterface userService;

    @Autowired
    UserRepository userRepository;

    @GetMapping("/users/{userId}")
    @ResponseStatus(HttpStatus.OK)
    public User getUserById(@PathVariable int userId) {
        return userRepository.findById(userId).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Wrong user id"));
    }

    @GetMapping("/users/{userId}/ratings")
    @ResponseStatus(HttpStatus.OK)
    public UserRating getUserRatings(@PathVariable int userId) {
        return userService.getUserRatings(userId);
    }
}
