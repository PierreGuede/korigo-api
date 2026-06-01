package com.korigo.api.commission.resources;

        import java.time.LocalDateTime;
import java.util.UUID;

        public record CommissionResource(
            UUID id,
    Double montant,
    Double pourcentage,
    UUID courseId,
    LocalDateTime createdAt,
    LocalDateTime updatedAt
        ) {
        }
