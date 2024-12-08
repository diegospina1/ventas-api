package com.commerce.application.dto.order;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDateTime;

public record UpdateOrderDto(
        @NotNull
        @Min(value = 1, message = "Invalid ID.")
        Integer id,
        @JsonFormat(pattern = "yyyy-MM-dd HH:mm")
        LocalDateTime delivered_date
) {
}
