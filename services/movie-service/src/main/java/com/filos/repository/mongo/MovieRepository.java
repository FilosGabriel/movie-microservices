package com.filos.repository.mongo;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;

import com.filos.repository.model.Movie;

public interface MovieRepository extends MongoRepository<Movie, String>, QuerydslPredicateExecutor<Movie> {

}
