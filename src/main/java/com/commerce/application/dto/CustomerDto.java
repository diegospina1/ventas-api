package com.commerce.application.dto;

import org.locationtech.jts.geom.Point;

public record CustomerDto(
        Integer id,
        String document,
        String firstname,
        String lastname,
        Point address
) {
}
