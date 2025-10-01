package com.example.bemestar_api.repository;

import com.example.bemestar_api.model.CheckIn;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CheckInRepository extends MongoRepository<CheckIn, String> {
}
