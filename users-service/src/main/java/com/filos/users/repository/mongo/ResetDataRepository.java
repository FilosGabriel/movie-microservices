package com.filos.users.repository.mongo;

import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.filos.users.repository.model.ResetData;

public interface ResetDataRepository extends MongoRepository<ResetData, String> {
    Optional<ResetData> findBySecret(String token);
}
