package com.fssa.dynamicdesign.dao.exception;

public class DatabaseDriverNotFoundException extends RuntimeException {
    private static final long serialVersionUID = 123456789L; // Use any valid long value

    public DatabaseDriverNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }
}

