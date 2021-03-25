package com.filos.data.repository;

import com.filos.data.MovieStatistics;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

public interface MovieRepository extends ReactiveMongoRepository<MovieStatistics, Integer>{
}
