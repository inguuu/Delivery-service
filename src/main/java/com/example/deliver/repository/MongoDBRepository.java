package com.example.deliver.repository;


import com.example.deliver.domain.Review;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


public interface MongoDBRepository extends MongoRepository<Review,Integer> {

    List<Review> findByStoreIdx(int storeIdx);

}