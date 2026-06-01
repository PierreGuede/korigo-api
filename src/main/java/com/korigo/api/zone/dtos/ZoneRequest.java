package com.korigo.api.zone.dtos;

    import jakarta.validation.constraints.NotBlank;

    public record ZoneRequest(
        @NotBlank String nom,
@NotBlank String type
    ) {
    }
