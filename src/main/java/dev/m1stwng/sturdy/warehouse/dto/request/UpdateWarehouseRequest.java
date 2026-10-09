package dev.m1stwng.sturdy.warehouse.dto.request;

import jakarta.validation.constraints.Size;

public record UpdateWarehouseRequest(@Size(max = 50) String alias) {
}
