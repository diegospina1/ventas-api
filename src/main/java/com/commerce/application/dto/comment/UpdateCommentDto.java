package com.commerce.application.dto.comment;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;

public record UpdateCommentDto(
        @NotNull
        @Min(value = 1, message = "Invalid ID.")
        Integer id,
        @Pattern(regexp = "[a-zA-Z0-9 ]+$")
        String message,
        @Min(value = 1, message = "Invalid Score: min 1, max 5.")
        @Max(value = 5, message = "Invalid Score: min 1, max 5.")
        Integer score
) {
}
