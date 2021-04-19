package com.filos.users.web.rest;

import lombok.RequiredArgsConstructor;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.filos.users.services.SecurityService;
import com.filos.users.web.dto.TwoResponse;

@RestController
@RequiredArgsConstructor
@RequestMapping("/users/security")
public class SecurityController {
    private final SecurityService service;

    @PostMapping("/2fa/sms")
    public void activateSMS2FA() {
        service.enableSMS2FA();
    }

    @PostMapping("/2fa/totp")
    public void activateTOTP2FA() {
        service.enableTOTP2FA();
    }
}
