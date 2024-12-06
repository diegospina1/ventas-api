package com.commerce.application.dto.branch;

import com.commerce.application.dto.Coordinates;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;

public record CreateCompanyBranchDto(
        @NotBlank
        @Pattern(regexp = "^[a-zA-Z0-9 ]+$")
        String name,
        @Valid
        Coordinates location
) {
}
