package com.filos.dto;

import java.time.LocalDate;

public record UserDto(String username, String password, boolean enabled, LocalDate lastAccess,
                      LocalDate lastUpdatePassword, boolean locked) {
}
