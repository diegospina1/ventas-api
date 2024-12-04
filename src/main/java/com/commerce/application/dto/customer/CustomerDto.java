package com.commerce.application.dto.customer;

import com.commerce.application.dto.Coordinates;

public record CustomerDto(
        Integer id,
        String document,
        String firstname,
        String lastname,
        Coordinates address
) {
}
