package com.filos.api;

import com.filos.dto.UserDto;

import java.util.Optional;

public interface AbstractUserDetailsRepository {
    Optional<UserDto> findByUsername(String username);
}
