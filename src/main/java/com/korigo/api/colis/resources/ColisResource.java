package com.korigo.api.colis.resources;

        import java.time.LocalDateTime;
import java.util.UUID;

        public record ColisResource(
            UUID id,
    String description,
    Double poids,
    UUID commandeId,
    LocalDateTime createdAt,
    LocalDateTime updatedAt
        ) {
        }
