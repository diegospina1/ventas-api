package com.commerce.application.dto.product;

import com.commerce.application.model.entity.CategoryEnum;
import jakarta.validation.constraints.*;

public record CreateProductDto(
        @NotBlank
        @Pattern(regexp = "^[a-zA-Z0-9 ]+$")
        String name,
        @NotNull(message = "No es una categoría válida.")
        CategoryEnum category,
        @NotNull
        @Min(value = 0, message = "El stock no puede ser menor que cero (0).")
        Integer stock,
        @NotNull
        @DecimalMin(value = "0.0", message = "El precio no puede ser menor que cero (0)")
        Float price
) {
}
