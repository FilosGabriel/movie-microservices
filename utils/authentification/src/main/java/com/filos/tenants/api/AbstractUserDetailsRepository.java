package com.filos.tenants.api;

import java.util.Optional;

import com.filos.dto.UserDto;

public interface AbstractUserDetailsRepository {
    Optional<UserDto> findByUsername(String username);
}
