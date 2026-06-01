package com.korigo.api.utilisateur.resources;

import java.time.LocalDateTime;
import java.util.UUID;

public record UtilisateurResource(
    UUID id,
    String nom,
    String telephone,
    String email,
    UUID roleId,
    LocalDateTime createdAt,
    LocalDateTime updatedAt
) {
}
