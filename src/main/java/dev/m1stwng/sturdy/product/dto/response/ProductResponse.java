package dev.m1stwng.sturdy.product.dto.response;

import java.util.UUID;

public record ProductResponse(

        UUID id,

        String sku,

        String name,

        String description,

        String category,

        String subcategory,

        boolean active
) {
}
