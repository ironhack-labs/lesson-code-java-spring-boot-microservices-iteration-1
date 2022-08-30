package com.ironhack.ratingsdataservice.DTO;

import com.ironhack.ratingsdataservice.model.Rating;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import java.util.Arrays;
import java.util.List;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserRating {
    private Integer userId;
    private List<Rating> ratings;
}
