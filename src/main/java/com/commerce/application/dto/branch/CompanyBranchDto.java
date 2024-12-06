package com.commerce.application.dto.branch;

import com.commerce.application.dto.Coordinates;
import jakarta.validation.Valid;
import org.locationtech.jts.geom.Point;

public record CompanyBranchDto(
        Integer id,
        String name,
        Coordinates location
) {
}
