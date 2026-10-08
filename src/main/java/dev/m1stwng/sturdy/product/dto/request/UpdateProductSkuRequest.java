package dev.m1stwng.sturdy.product.dto.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record UpdateProductSkuRequest(

        @NotBlank
        @Size(max = 50)
        String sku
) {
}
