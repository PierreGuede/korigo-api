package com.korigo.api.wallettransaction.dtos;

        import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PositiveOrZero;
import java.util.UUID;

        public record WalletTransactionRequest(
            @NotBlank String type,
    @PositiveOrZero Double montant,
    String description,
    @NotNull UUID utilisateurId
        ) {
        }
