package com.ironhack.movieinfoservice.repository;

import com.ironhack.movieinfoservice.model.Movie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MovieRepository extends JpaRepository<Movie,String> {
}
