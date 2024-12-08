package com.commerce.application.dto.customer;

import com.commerce.application.dto.Coordinates;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;

public record CreateCustomerDto(
        @NotBlank
        @Pattern(regexp = "^\\d{10}$")
        String document,
        @NotBlank
        @Pattern(regexp = "^[A-Za-z]+(?:\\s[A-Za-z]+)?$")
        String firstname,
        @NotBlank
        @Pattern(regexp = "^[A-Za-z]+(?:\\s[A-Za-z]+)?$")
        String lastname,
        @Valid
        Coordinates address
) {
}
