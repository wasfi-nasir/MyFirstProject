package com.example.interviews.exception;

public class CommonException extends RuntimeException {

    private ErrorEnums error;
    public CommonException(ErrorEnums error) {
        super(error.getMessage());
        this.error = error;
    }
    public ErrorEnums getError() {
        return error;
    }
    public void setError(ErrorEnums error) {
        this.error = error;
    }

}