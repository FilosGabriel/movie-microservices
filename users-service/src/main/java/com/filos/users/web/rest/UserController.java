package com.filos.users.web.rest;

import com.filos.domain.dto.UserDto;
import com.filos.domain.dto.UserQRCodeDto;
import com.filos.requests.users.FindUser;
import com.filos.users.security.QRCodeGenerator;
import com.filos.users.services.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

import static org.springframework.http.HttpStatus.OK;

@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;
    private final QRCodeGenerator generator;

    @PostMapping("/register")
    @ResponseStatus(HttpStatus.CREATED)
    public UserQRCodeDto createUser(@Valid @RequestBody UserDto user) {
        return userService.createUser(user);
    }

    @GetMapping("/exists")
    @ResponseStatus(HttpStatus.OK)
    public void checkIfUserExists(@RequestBody @Valid FindUser user) {
        userService.checkExistenceOfUser(user);
    }

    @PostMapping("/login")
    @ResponseStatus(OK)
    public String authentificateUser() {
        return "";
    }
}
