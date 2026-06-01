package com.korigo.api.course.dtos;

        import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PositiveOrZero;
import java.time.LocalDateTime;
import java.util.UUID;

        public record CourseRequest(
            @PositiveOrZero Double distanceKm,
    @PositiveOrZero Double prix,
    @NotBlank String statut,
    @NotNull LocalDateTime startTime,
    LocalDateTime endTime,
    @NotNull UUID clientId,
    @NotNull UUID chauffeurId,
    @NotNull UUID vehiculeId
        ) {
        }
