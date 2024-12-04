package com.commerce.application.dto.customer;

import com.commerce.application.dto.Coordinates;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;

public record UpdateCustomerDto(
        @NotBlank
        @Pattern(regexp = "^\\d{10}$")
        String document,
        @Pattern(regexp = "^[A-Za-z]+(?:\\s[A-Za-z]+)?$")
        String firstname,
        @Pattern(regexp = "^[A-Za-z]+(?:\\s[A-Za-z]+)?$")
        String lastname,
        Coordinates address
) {
}
