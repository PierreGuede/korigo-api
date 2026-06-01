package com.korigo.api.vehicule.resources;

        import java.time.LocalDateTime;
import java.util.UUID;

        public record VehiculeResource(
            UUID id,
    String type,
    String marque,
    String modele,
    String immatriculation,
    String couleur,
    UUID chauffeurId,
    LocalDateTime createdAt,
    LocalDateTime updatedAt
        ) {
        }
