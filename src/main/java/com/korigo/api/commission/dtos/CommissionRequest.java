package com.korigo.api.commission.dtos;

        import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PositiveOrZero;
import java.util.UUID;

        public record CommissionRequest(
            @PositiveOrZero Double montant,
    @PositiveOrZero Double pourcentage,
    @NotNull UUID courseId
        ) {
        }
