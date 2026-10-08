package dev.m1stwng.sturdy.common.exception;

import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
public class BaseException extends RuntimeException {

    private final HttpStatus status;
    private final String title;
    private final String details;

    public BaseException(HttpStatus status, String title, String details) {
        this.status = status;
        this.title = title;
        this.details = details;
        super(details);
    }
}
