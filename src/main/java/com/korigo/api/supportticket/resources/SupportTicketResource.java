package com.korigo.api.supportticket.resources;

        import java.time.LocalDateTime;
import java.util.UUID;

        public record SupportTicketResource(
            UUID id,
    String sujet,
    String message,
    String statut,
    UUID utilisateurId,
    LocalDateTime createdAt,
    LocalDateTime updatedAt
        ) {
        }
