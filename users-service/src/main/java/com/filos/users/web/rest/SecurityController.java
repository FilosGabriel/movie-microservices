package com.filos.users.web.rest;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.filos.users.services.security.SecurityService;
import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("/users/security")
public class SecurityController {
    private final SecurityService service;

    @PostMapping("/2fa/sms")
    public void activateSMS2FA() {
        service.activateMethod(null);
    }

    @PostMapping("/2fa/totp")
    public void activateTOTP2FA() {
        service.activateMethod(null);
    }
}
