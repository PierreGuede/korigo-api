package com.korigo.api.retrait.dtos;

        import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PositiveOrZero;
import java.util.UUID;

        public record RetraitRequest(
            @PositiveOrZero Double montant,
    @NotBlank String methode,
    @NotBlank String statut,
    @NotNull UUID chauffeurId
        ) {
        }
