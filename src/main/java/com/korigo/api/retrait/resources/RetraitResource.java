package com.korigo.api.retrait.resources;

        import java.time.LocalDateTime;
import java.util.UUID;

        public record RetraitResource(
            UUID id,
    Double montant,
    String methode,
    String statut,
    UUID chauffeurId,
    LocalDateTime createdAt,
    LocalDateTime updatedAt
        ) {
        }
