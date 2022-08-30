package com.ironhack.ratingsdataservice.service.interfaces;

import com.ironhack.ratingsdataservice.DTO.UserRating;

public interface UserServiceInterface {
    UserRating getUserRatings(int userId);
}
