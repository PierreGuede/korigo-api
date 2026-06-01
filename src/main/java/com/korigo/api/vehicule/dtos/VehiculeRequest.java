package com.korigo.api.vehicule.dtos;

        import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import java.util.UUID;

        public record VehiculeRequest(
            @NotBlank String type,
    @NotBlank String marque,
    @NotBlank String modele,
    @NotBlank String immatriculation,
    String couleur,
    @NotNull UUID chauffeurId
        ) {
        }
