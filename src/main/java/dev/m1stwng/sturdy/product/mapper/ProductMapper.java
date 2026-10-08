package dev.m1stwng.sturdy.product.mapper;

import dev.m1stwng.sturdy.product.dto.response.ProductResponse;
import dev.m1stwng.sturdy.product.entity.Product;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ProductMapper {

    ProductResponse toResponse(Product product);
}
