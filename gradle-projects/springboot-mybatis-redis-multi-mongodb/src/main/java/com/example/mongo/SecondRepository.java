package com.example.mongo;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface SecondRepository extends MongoRepository<PrimaryMongoObject, String> {
}