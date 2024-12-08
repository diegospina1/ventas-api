package com.commerce.application.dto.itemReturn;

import com.commerce.application.model.entity.ReturnStatus;
import com.fasterxml.jackson.annotation.JsonFormat;

import java.time.LocalDateTime;

public record ItemReturnDto(
        Integer id,
        Integer order_item_id,
        Integer company_branch_id,
        String reason,
        Integer quantity,
        @JsonFormat(pattern = "yyyy-MM-dd HH:mm")
        LocalDateTime return_date,
        ReturnStatus status
) {
}
