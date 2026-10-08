package dev.m1stwng.sturdy.common.exception;

import org.springframework.http.ProblemDetail;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(BaseException.class)
    public ProblemDetail handleBaseException(BaseException ex) {
        final ProblemDetail problemDetail = ProblemDetail.forStatus(ex.getStatus());

        problemDetail.setTitle(ex.getTitle());
        problemDetail.setDetail(ex.getDetails());

        return problemDetail;
    }
}