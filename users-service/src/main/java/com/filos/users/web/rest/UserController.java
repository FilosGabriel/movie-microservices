package com.filos.users.web.rest;

import com.filos.domain.dto.UserDto;
import com.filos.users.aop.logging.LogExecutionTime;
import com.filos.users.services.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;

    @PostMapping
    @LogExecutionTime
    public ResponseEntity<UserDto> createUser(UserDto user) {
        UserDto userResponse = userService.createUser(user);
        return ResponseEntity.ok(userResponse);
    }

    @GetMapping
    @LogExecutionTime
    public String get() {
        return "daa";
    }
}
