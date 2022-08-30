package com.ironhack.movieinfoservice;

import com.ironhack.movieinfoservice.model.Movie;
import com.ironhack.movieinfoservice.repository.MovieRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.ArrayList;

@SpringBootApplication
public class MovieInfoServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(MovieInfoServiceApplication.class, args);
    }

    @Bean
    CommandLineRunner run(MovieRepository movieRepository) {
        return args -> {

            movieRepository.save(new Movie("m1", "Beetlejuice", "A couple of recently deceased ghosts contract the services of a 'bio-exorcist' in order to remove the obnoxious new owners of their house."));
            movieRepository.save(new Movie("m2", "The Cotton Club", "The Cotton Club was a famous night club in Harlem. The story follows the people that visited the club, those that ran it, and is peppered with the Jazz music that made it so famous."));
            movieRepository.save(new Movie("m3", "Valkyrie", "A dramatization of the 20 July assassination and political coup plot by desperate renegade German Army officers against Hitler during World War II."));
            movieRepository.save(new Movie("m4", "Ratatouille", "A rat who can cook makes an unusual alliance with a young kitchen worker at a famous restaurant."));
        };
    }

}
