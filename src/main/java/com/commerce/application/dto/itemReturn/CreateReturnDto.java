package com.commerce.application.dto.itemReturn;

import com.commerce.application.model.entity.ReturnStatus;
import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;

import java.time.LocalDateTime;

public record CreateReturnDto(
        @NotNull
        @Min(value = 1, message = "Invalid order item ID")
        Integer order_item_id,
        @NotNull
        @Min(value = 1, message = "Invalid branch ID")
        Integer company_branch_id,
        @NotNull
        @Pattern(regexp = "^[a-zA-Z0-9 ]+$")
        String reason,
        @NotNull
        @Min(value = 1, message = "Invalid quantity")
        Integer quantity,
        @NotNull
        @JsonFormat(pattern = "yyyy-MM-dd HH:mm")
        LocalDateTime return_date,
        @NotNull
        ReturnStatus status
) {
}
