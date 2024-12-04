package com.commerce.application.dto;

import com.commerce.application.model.entity.CategoryEnum;

public record ProductDto(
        Integer id,
        CategoryEnum category,
        Integer stock,
        Float price
) {
}
