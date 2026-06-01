package com.korigo.api.restaurant.resources;

        import java.time.LocalDateTime;
import java.util.UUID;

        public record RestaurantResource(
            UUID id,
    String nom,
    String adresse,
    String telephone,
    LocalDateTime createdAt,
    LocalDateTime updatedAt
        ) {
        }
