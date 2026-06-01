package com.korigo.api.paiement.dtos;

        import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PositiveOrZero;
import java.util.UUID;

        public record PaiementRequest(
            @NotBlank String mode,
    @PositiveOrZero Double montant,
    @NotNull UUID utilisateurId,
    UUID courseId,
    UUID commandeId
        ) {
        }
