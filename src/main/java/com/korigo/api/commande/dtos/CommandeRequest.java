package com.korigo.api.commande.dtos;

        import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PositiveOrZero;
import java.util.UUID;

        public record CommandeRequest(
            @PositiveOrZero Double montant,
    @NotBlank String statut,
    @NotNull UUID clientId,
    @NotNull UUID restaurantId,
    @NotNull UUID chauffeurId
        ) {
        }
