package com.commerce.application.dto.comment;

import com.commerce.application.dto.customer.CustomerDto;
import com.commerce.application.dto.product.ProductDto;

public record CommentDto(
        Integer id,
        CustomerDto customer,
        ProductDto product,
        String message,
        Integer score
) {
}
