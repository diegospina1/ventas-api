package com.commerce.application.dto.itemReturn;

import com.commerce.application.model.entity.ReturnStatus;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;

public record UpdateReturnDto(
        @NotNull
        @Min(value = 1, message = "Invalid ID")
        Integer id,
        @NotNull
        ReturnStatus status
) {
}
