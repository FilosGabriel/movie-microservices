package com.filos.repository.mongo;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.filos.repository.model.Movie;

public interface MovieRepository extends MongoRepository<Movie, Long> {

}
