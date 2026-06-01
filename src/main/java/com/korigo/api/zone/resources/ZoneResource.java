package com.korigo.api.zone.resources;

        import java.time.LocalDateTime;
import java.util.UUID;

        public record ZoneResource(
            UUID id,
    String nom,
    String type,
    LocalDateTime createdAt,
    LocalDateTime updatedAt
        ) {
        }
