package com.korigo.api.role.dtos;

    import jakarta.validation.constraints.NotBlank;

    public record RoleRequest(
        @NotBlank String nom,
String description
    ) {
    }
