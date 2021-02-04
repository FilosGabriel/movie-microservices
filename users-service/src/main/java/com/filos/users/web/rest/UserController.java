package com.filos.users.web.rest;

import com.filos.domain.dto.*;
import com.filos.model.dto.UserQRCodeDto;
import com.filos.users.security.QRCodeGenerator;
import com.filos.users.services.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;
    private final QRCodeGenerator generator;

    @PostMapping
    public ResponseEntity<UserQRCodeDto> createUser(@RequestBody UserDto user) {
        UserQRCodeDto userResponse = userService.createUser(user);
        userResponse.setOtp(generator.createQRCode());
        return ResponseEntity.ok(userResponse);
    }


}
