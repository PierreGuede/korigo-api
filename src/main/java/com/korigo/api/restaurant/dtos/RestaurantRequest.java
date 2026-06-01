package com.korigo.api.restaurant.dtos;

    import jakarta.validation.constraints.NotBlank;

    public record RestaurantRequest(
        @NotBlank String nom,
@NotBlank String adresse,
@NotBlank String telephone
    ) {
    }
