package com.korigo.api.promotion.resources;

        import java.time.LocalDateTime;
import java.util.UUID;

        public record PromotionResource(
            UUID id,
    String code,
    Double reduction,
    LocalDateTime dateDebut,
    LocalDateTime dateFin,
    LocalDateTime createdAt,
    LocalDateTime updatedAt
        ) {
        }
