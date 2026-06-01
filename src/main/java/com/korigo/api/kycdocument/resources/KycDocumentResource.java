package com.korigo.api.kycdocument.resources;

        import java.time.LocalDateTime;
import java.util.UUID;

        public record KycDocumentResource(
            UUID id,
    String typeDocument,
    String statut,
    UUID chauffeurId,
    LocalDateTime createdAt,
    LocalDateTime updatedAt
        ) {
        }
