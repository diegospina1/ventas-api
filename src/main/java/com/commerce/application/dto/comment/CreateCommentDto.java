package com.commerce.application.dto.comment;

import com.commerce.application.dto.customer.CustomerDto;
import com.commerce.application.dto.product.ProductDto;
import jakarta.validation.constraints.*;

public record CreateCommentDto(
        @NotNull
        @Min(value = 1, message = "Invalid customer ID.")
        Integer customer_id,
        @NotNull
        @Min(value = 1, message = "Invalid customer ID.")
        Integer product_id,
        @NotBlank
        @Pattern(regexp = "[a-zA-Z0-9ñÑ ]+$")
        String message,
        @NotNull
        @Min(value = 1, message = "Invalid Score: min 1, max 5.")
        @Max(value = 5, message = "Invalid Score: min 1, max 5.")
        Integer score
) {
}
