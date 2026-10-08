package dev.m1stwng.sturdy.product.dto.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record UpdateProductRequest(

        @NotBlank
        @Size(max = 255)
        String name,

        @Size(max = 2500)
        String description,

        @NotBlank
        @Size(max = 255)
        String category,

        @Size(max = 255)
        String subcategory
) {
}
