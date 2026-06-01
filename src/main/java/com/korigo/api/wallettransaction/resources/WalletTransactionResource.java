package com.korigo.api.wallettransaction.resources;

        import java.time.LocalDateTime;
import java.util.UUID;

        public record WalletTransactionResource(
            UUID id,
    String type,
    Double montant,
    String description,
    UUID utilisateurId,
    LocalDateTime createdAt,
    LocalDateTime updatedAt
        ) {
        }
