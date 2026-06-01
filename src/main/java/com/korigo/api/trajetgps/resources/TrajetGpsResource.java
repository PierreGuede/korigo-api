package com.korigo.api.trajetgps.resources;

        import java.time.LocalDateTime;
import java.util.UUID;

        public record TrajetGpsResource(
            UUID id,
    Double latitude,
    Double longitude,
    LocalDateTime timestamp,
    UUID courseId,
    LocalDateTime createdAt,
    LocalDateTime updatedAt
        ) {
        }
