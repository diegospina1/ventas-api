package com.commerce.application.dto.order;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDateTime;

public record CreateOrderDto(
        @NotNull
        @Min(value = 1, message = "Invalid ID.")
        Integer customer_id,
        @NotNull
        @JsonFormat(pattern = "yyyy-MM-dd HH:mm")
        LocalDateTime order_date,
        @NotNull
        @JsonFormat(pattern = "yyyy-MM-dd HH:mm")
        LocalDateTime delivered_date
) {
}
