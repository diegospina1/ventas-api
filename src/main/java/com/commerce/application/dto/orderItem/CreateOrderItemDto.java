package com.commerce.application.dto.orderItem;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;

public record CreateOrderItemDto(
        @NotNull
        @Min(value = 1, message = "Invalid order ID")
        Integer order_id,
        @NotNull
        @Min(value = 1, message = "Invalid product ID")
        Integer product_id,
        @NotNull
        @Min(value = 1, message = "Invalid product quantity")
        Integer quantity
) {
}
