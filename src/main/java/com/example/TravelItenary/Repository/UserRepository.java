package com.example.TravelItenary.Repository;

import com.example.TravelItenary.Entity.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends MongoRepository<User, String> {

     //Optional<User> findById(String id);
      Optional<User> findByEmail(String email);
}
