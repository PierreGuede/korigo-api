package com.korigo.api.colis.dtos;

        import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PositiveOrZero;
import java.util.UUID;

        public record ColisRequest(
            @NotBlank String description,
    @PositiveOrZero Double poids,
    @NotNull UUID commandeId
        ) {
        }
