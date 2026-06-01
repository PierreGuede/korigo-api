package com.korigo.api.role.resources;

        import java.time.LocalDateTime;
import java.util.UUID;

        public record RoleResource(
            UUID id,
    String nom,
    String description,
    LocalDateTime createdAt,
    LocalDateTime updatedAt
        ) {
        }
