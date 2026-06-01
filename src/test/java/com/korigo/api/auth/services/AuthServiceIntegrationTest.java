package com.korigo.api.auth.services;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import com.korigo.api.auth.dtos.LoginRequest;
import com.korigo.api.shared.exceptions.InvalidCredentialsException;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class AuthServiceIntegrationTest {

    @Autowired
    private AuthService authService;

    @Test
    void shouldLoginWithSeededDemoAccount() {
        var session = authService.login(new LoginRequest("client.demo@korigo.app", "KoriGo123!"));

        assertEquals("client.demo@korigo.app", session.email());
        assertEquals("Compte Demo", session.nom());
    }

    @Test
    void shouldRejectInvalidPassword() {
        assertThrows(
            InvalidCredentialsException.class,
            () -> authService.login(new LoginRequest("client.demo@korigo.app", "mauvais-mot-de-passe"))
        );
    }
}
