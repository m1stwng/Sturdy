package dev.m1stwng.sturdy.warehouse.mapper;

import dev.m1stwng.sturdy.warehouse.dto.response.WarehouseResponse;
import dev.m1stwng.sturdy.warehouse.entity.Warehouse;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface WarehouseMapper {

    WarehouseResponse toResponse(Warehouse warehouse);
}
