package com.korigo.api.kycdocument.dtos;

        import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import java.util.UUID;

        public record KycDocumentRequest(
            @NotBlank String typeDocument,
    @NotBlank String statut,
    @NotNull UUID chauffeurId
        ) {
        }
