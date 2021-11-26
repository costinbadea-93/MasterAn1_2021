package com.example.ex1.exceptions;

public class NoSufficientQuantityException extends RuntimeException {
    public NoSufficientQuantityException(String exceptionMsg) {
        super(exceptionMsg);
    }
}
