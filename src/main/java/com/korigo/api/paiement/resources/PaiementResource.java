package com.korigo.api.paiement.resources;

        import java.time.LocalDateTime;
import java.util.UUID;

        public record PaiementResource(
            UUID id,
    String mode,
    Double montant,
    UUID utilisateurId,
    UUID courseId,
    UUID commandeId,
    LocalDateTime createdAt,
    LocalDateTime updatedAt
        ) {
        }
