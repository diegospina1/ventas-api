package com.commerce.application.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record Coordinates(
        @NotNull(message = "Coordinates cannot be null")
        Double longitud,
        @NotNull(message = "Coordinates cannot be null")
        Double latitud
) {
}
