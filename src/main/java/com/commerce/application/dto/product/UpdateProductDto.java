package com.commerce.application.dto.product;

import com.commerce.application.model.entity.CategoryEnum;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;

public record UpdateProductDto(
        @NotNull
        Integer id,
        @Pattern(regexp = "^[a-zA-Z0-9ñÑ ]+$")
        String name,
        CategoryEnum category,
        @Min(value = 0, message = "El stock no puede ser menor que cero (0).")
        Integer stock,
        @DecimalMin(value = "0.0", message = "El precio no puede ser menor que cero (0)")
        Float price
) {
}
