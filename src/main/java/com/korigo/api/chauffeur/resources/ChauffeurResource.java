package com.korigo.api.chauffeur.resources;

        import java.time.LocalDateTime;
import java.util.UUID;

        public record ChauffeurResource(
            UUID id,
    Boolean actif,
    String statut,
    Double note,
    UUID utilisateurId,
    LocalDateTime createdAt,
    LocalDateTime updatedAt
        ) {
        }
