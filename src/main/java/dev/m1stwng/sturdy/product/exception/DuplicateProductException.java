package dev.m1stwng.sturdy.product.exception;

import dev.m1stwng.sturdy.common.exception.BaseException;
import org.springframework.http.HttpStatus;

public class DuplicateProductException extends BaseException {
    public DuplicateProductException(String sku) {
        super(HttpStatus.CONFLICT, "Duplicate product SKU", "Product with SKU %s already exists".formatted(sku));
    }
}
