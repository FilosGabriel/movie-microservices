package com.filos.users.web.rest;

import static org.springframework.http.HttpStatus.OK;

import javax.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.filos.domain.dto.UserDto;
import com.filos.domain.dto.UserQRCodeDto;
import com.filos.requests.users.FindUser;
import com.filos.users.services.security.qr.QRCodeGenerator;
import com.filos.users.services.user.UserService;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;
    private final QRCodeGenerator generator;
    public static int E = 1;
    public static int E2 = 2;

    @PostMapping("/register")
    @ResponseStatus(HttpStatus.CREATED)
    public UserQRCodeDto createUser(@Valid @RequestBody UserDto user) {
        return userService.createUser(user);
    }

    @GetMapping("/exists")
    @ResponseStatus(HttpStatus.OK)
    public void checkIfUserExists(@Valid FindUser user) {
        userService.checkExistenceOfUser(user);
    }


    @PostMapping("/login")
    @ResponseStatus(OK)
    public String authenticateUser() {
        return "ok";
    }
}
