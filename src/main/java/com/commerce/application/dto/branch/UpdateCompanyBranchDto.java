package com.commerce.application.dto.branch;

import com.commerce.application.dto.Coordinates;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;

public record UpdateCompanyBranchDto(
        @NotNull
        Integer id,
        @Pattern(regexp = "^[a-zA-Z0-9ñÑ ]+$")
        String name,
        Coordinates location
) {
}
