package com.ironhack.ratingsdataservice.repository;

import com.ironhack.ratingsdataservice.model.Rating;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RatingRepository extends JpaRepository<Rating,Integer> {
    List<Rating> findByMovieId(String movieId);
}
