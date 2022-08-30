package com.ironhack.ratingsdataservice.repository;

import com.ironhack.ratingsdataservice.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User,Integer> {
}
