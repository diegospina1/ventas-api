package com.commerce.application.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record Coordinates(
        Double longitud,
        Double latitud
) {
}
