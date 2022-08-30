package com.ironhack.ratingsdataservice.service.impl;

import com.ironhack.ratingsdataservice.model.Rating;
import com.ironhack.ratingsdataservice.model.User;
import com.ironhack.ratingsdataservice.DTO.UserRating;
import com.ironhack.ratingsdataservice.repository.RatingRepository;
import com.ironhack.ratingsdataservice.repository.UserRepository;
import com.ironhack.ratingsdataservice.service.interfaces.UserServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@Service
public class UserService implements UserServiceInterface {

    @Autowired
    UserRepository userRepository;
    @Autowired
    RatingRepository ratingRepository;

    public UserRating getUserRatings(int userId){
        Optional<User> userFromDb =  userRepository.findById(userId);
        if(userFromDb.isPresent()){
            List<Rating> userRatings = userFromDb.get().getRatings();
            return new UserRating(userId,userRatings);
        }
        else{
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,"User not found");
        }
    }

    public void addRatingToUser(Integer ratingId, Integer userId) {
        User user = userRepository.findById(userId).get();
        Rating rating = ratingRepository.findById(ratingId).get();
        user.getRatings().add(rating);
        userRepository.save(user);
    }
}
