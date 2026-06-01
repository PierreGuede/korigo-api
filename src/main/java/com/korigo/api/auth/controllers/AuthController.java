package com.korigo.api.auth.controllers;

import com.korigo.api.auth.dtos.LoginRequest;
import com.korigo.api.auth.resources.AuthSessionResource;
import com.korigo.api.auth.services.AuthService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    private final AuthService authService;

    public AuthController(AuthService authService) {
        this.authService = authService;
    }

    @PostMapping("/login")
    public AuthSessionResource login(@Valid @RequestBody LoginRequest request) {
        return authService.login(request);
    }
}
