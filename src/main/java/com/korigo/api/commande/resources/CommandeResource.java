package com.korigo.api.commande.resources;

        import java.time.LocalDateTime;
import java.util.UUID;

        public record CommandeResource(
            UUID id,
    Double montant,
    String statut,
    UUID clientId,
    UUID restaurantId,
    UUID chauffeurId,
    LocalDateTime createdAt,
    LocalDateTime updatedAt
        ) {
        }
