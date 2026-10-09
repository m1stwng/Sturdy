package dev.m1stwng.sturdy.warehouse.dto.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record CreateWarehouseRequest(

        @NotBlank
        @Size(max = 50)
        String code,

        @Size(max = 50)
        String alias
) {
}
