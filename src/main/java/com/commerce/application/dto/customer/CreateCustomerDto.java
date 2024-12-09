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
        @Pattern(regexp = "^[A-Za-zñÑ]+(?:\\s[A-Za-zñÑ]+)?$")
        String firstname,
        @NotBlank
        @Pattern(regexp = "^[A-Za-zñÑ]+(?:\\s[A-Za-zñÑ]+)?$")
        String lastname,
        @Valid
        Coordinates address
) {
}
