package com.example.deliver.repository;


import com.example.deliver.domain.Review;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface MongoDBRepository extends MongoRepository<Review,Integer> {

    Iterable<Review> findAllByIdAndStoreIdx(String id, int storeIdx);

}