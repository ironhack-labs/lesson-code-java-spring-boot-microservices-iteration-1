package com.ironhack.ratingsdataservice;

import com.ironhack.ratingsdataservice.model.Rating;
import com.ironhack.ratingsdataservice.model.User;
import com.ironhack.ratingsdataservice.repository.RatingRepository;
import com.ironhack.ratingsdataservice.repository.UserRepository;
import com.ironhack.ratingsdataservice.service.impl.UserService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.ArrayList;

@SpringBootApplication
public class RatingsDataServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(RatingsDataServiceApplication.class, args);
	}

	@Bean
	CommandLineRunner run(UserRepository userRepository, RatingRepository ratingRepository, UserService userService) {
		return args -> {

			userRepository.save(new User(null,"Ray","Raymond",new ArrayList<>()));
			ratingRepository.save(new Rating(null,5,"m1"));
			ratingRepository.save(new Rating(null,3,"m1"));

			userService.addRatingToUser(1, 1);
			userService.addRatingToUser(2, 1);


		};
	}

}
