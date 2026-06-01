package com.korigo.api.trajetgps.dtos;

        import jakarta.validation.constraints.NotNull;
import java.time.LocalDateTime;
import java.util.UUID;

        public record TrajetGpsRequest(
            @NotNull Double latitude,
    @NotNull Double longitude,
    @NotNull LocalDateTime timestamp,
    @NotNull UUID courseId
        ) {
        }
