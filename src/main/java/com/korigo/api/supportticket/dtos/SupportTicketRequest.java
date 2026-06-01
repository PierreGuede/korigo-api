package com.korigo.api.supportticket.dtos;

        import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import java.util.UUID;

        public record SupportTicketRequest(
            @NotBlank String sujet,
    @NotBlank String message,
    @NotBlank String statut,
    @NotNull UUID utilisateurId
        ) {
        }
