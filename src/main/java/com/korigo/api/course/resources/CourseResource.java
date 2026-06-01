package com.korigo.api.course.resources;

        import java.time.LocalDateTime;
import java.util.UUID;

        public record CourseResource(
            UUID id,
    Double distanceKm,
    Double prix,
    String statut,
    LocalDateTime startTime,
    LocalDateTime endTime,
    UUID clientId,
    UUID chauffeurId,
    UUID vehiculeId,
    LocalDateTime createdAt,
    LocalDateTime updatedAt
        ) {
        }
