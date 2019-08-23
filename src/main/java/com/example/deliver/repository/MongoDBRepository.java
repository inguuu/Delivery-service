package com.example.deliver.repository;


import com.example.deliver.domain.Review;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface MongoDBRepository extends MongoRepository<Review,Integer> {
}