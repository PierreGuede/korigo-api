package com.korigo.api.auth.services;

import com.korigo.api.auth.dtos.LoginRequest;
import com.korigo.api.auth.resources.AuthSessionResource;
import com.korigo.api.shared.exceptions.InvalidCredentialsException;
import com.korigo.api.utilisateur.mappings.UtilisateurMapper;
import com.korigo.api.utilisateur.services.UtilisateurService;
import java.util.Locale;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(readOnly = true)
public class AuthService {

    private final UtilisateurService utilisateurService;
    private final PasswordEncoder passwordEncoder;

    public AuthService(UtilisateurService utilisateurService, PasswordEncoder passwordEncoder) {
        this.utilisateurService = utilisateurService;
        this.passwordEncoder = passwordEncoder;
    }

    public AuthSessionResource login(LoginRequest request) {
        var normalizedEmail = request.email().trim().toLowerCase(Locale.ROOT);
        var user = utilisateurService.findEntityByEmail(normalizedEmail)
            .orElseThrow(() -> new InvalidCredentialsException("Email ou mot de passe incorrect."));

        if (user.getPasswordHash() == null || user.getPasswordHash().isBlank()) {
            throw new InvalidCredentialsException("Ce compte ne peut pas encore se connecter par mot de passe.");
        }

        if (!passwordEncoder.matches(request.password(), user.getPasswordHash())) {
            throw new InvalidCredentialsException("Email ou mot de passe incorrect.");
        }

        return UtilisateurMapper.toAuthSessionResource(user);
    }
}
