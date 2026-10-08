package dev.m1stwng.sturdy.product.exception;

import dev.m1stwng.sturdy.common.exception.BaseException;
import org.springframework.http.HttpStatus;

import java.util.UUID;

public class ProductNotFoundException extends BaseException {
    public ProductNotFoundException(UUID id) {
        super(HttpStatus.NOT_FOUND, "Product was not found", "Product with id %s was not found".formatted(id));
    }
}
