package dev.m1stwng.sturdy.warehouse.exception;

import dev.m1stwng.sturdy.common.exception.BaseException;
import org.springframework.http.HttpStatus;

public class DuplicateWarehouseException extends BaseException {
    public DuplicateWarehouseException(String code) {
        super(HttpStatus.CONFLICT, "Duplicate warehouse code", "Warehouse with code %s already exists".formatted(code));
    }
}
