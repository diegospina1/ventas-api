package com.commerce.application.dto.orderItem;

public record OrderItemDto(
        Integer id,
        Integer order_id,
        Integer product_id,
        Integer quantity,
        Float total_price
) {
}
