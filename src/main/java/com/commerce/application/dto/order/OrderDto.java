package com.commerce.application.dto.order;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.time.LocalDateTime;

public record OrderDto(
        Integer id,
        Integer customer_id,
        @JsonFormat(pattern = "yyyy-MM-dd HH:mm")
        LocalDateTime order_date,
        @JsonFormat(pattern = "yyyy-MM-dd HH:mm")
        LocalDateTime delivered_date
) {
}
