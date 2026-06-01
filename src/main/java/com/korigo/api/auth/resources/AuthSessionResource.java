package com.korigo.api.auth.resources;

import java.util.UUID;

public record AuthSessionResource(
    UUID userId,
    String nom,
    String telephone,
    String email,
    UUID roleId
) {
}
