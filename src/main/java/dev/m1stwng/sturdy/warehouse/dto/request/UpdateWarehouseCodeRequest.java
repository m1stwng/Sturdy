package dev.m1stwng.sturdy.warehouse.dto.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record UpdateWarehouseCodeRequest(

        @NotBlank
        @Size(max = 50)
        String code
) {
}
