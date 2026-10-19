package org.example.validation.service;

import org.example.validation.model.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepo extends MongoRepository<User, String> {
    
    List<User> findAllByAgeAfter(Integer ageAfter);

}