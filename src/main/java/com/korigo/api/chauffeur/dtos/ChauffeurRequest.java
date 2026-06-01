package com.korigo.api.chauffeur.dtos;

        import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PositiveOrZero;
import java.util.UUID;

        public record ChauffeurRequest(
            @NotNull Boolean actif,
    @NotBlank String statut,
    @PositiveOrZero Double note,
    @NotNull UUID utilisateurId
        ) {
        }
