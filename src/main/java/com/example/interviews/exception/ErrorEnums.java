package com.example.interviews.exception;
import org.springframework.http.HttpStatus;

public enum ErrorEnums {
    USER_NOT_FOUND("User not found",  HttpStatus.NOT_FOUND),
    PAGE_INVALID("page > 0",  HttpStatus.BAD_REQUEST),
    USERS_NOT_FOUND("there is no candidates in DB", HttpStatus.NOT_FOUND);

    private String message;
    private HttpStatus status;
    ErrorEnums(String message, HttpStatus status) {
        this.message = message;
        this.status = status;
    }
    public String getMessage() {
        return message;
    }
    public HttpStatus getStatus() {
        return status;
    }

}