package com.korigo.api.promotion.dtos;

        import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PositiveOrZero;
import java.time.LocalDateTime;

        public record PromotionRequest(
            @NotBlank String code,
    @PositiveOrZero Double reduction,
    @NotNull LocalDateTime dateDebut,
    @NotNull LocalDateTime dateFin
        ) {
        }
