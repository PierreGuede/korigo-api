package com.korigo.api.utilisateur.dtos;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import java.util.UUID;

public record UtilisateurRequest(
    @NotBlank String nom,
    @NotBlank String telephone,
    @NotBlank @Email String email,
    String password,
    @NotNull UUID roleId
) {
}
