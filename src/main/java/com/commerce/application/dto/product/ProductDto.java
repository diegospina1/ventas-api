package com.commerce.application.dto.product;

import com.commerce.application.model.entity.CategoryEnum;

public record ProductDto(
        Integer id,
        String name,
        CategoryEnum category,
        Integer stock,
        Float price
) {
}
