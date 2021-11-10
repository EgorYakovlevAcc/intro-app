package com.hexletlection.introapp.exception;

public class CustomException extends Exception {
    private String errorCode;
    private String message;

    public CustomException(String errorCode, String message) {
        this.errorCode = errorCode;
        this.message = message;
    }

    public String getErrorCode() {
        return errorCode;
    }

    @Override
    public String getMessage() {
        return message;
    }
}
