package com.commerce.application.dto.orderItem;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;

public record UpdateOrderItemDto(
        @NotNull
        @Min(value = 1, message = "Invalid ID")
        Integer id,
        @Min(value = 1, message = "Invalid product quantity")
        Integer quantity
) {
}
