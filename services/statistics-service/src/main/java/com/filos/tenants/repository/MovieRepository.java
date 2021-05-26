package com.filos.tenants.repository;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

import com.filos.data.MovieStatistics;

public interface MovieRepository extends ReactiveMongoRepository<MovieStatistics, Integer> {
}
