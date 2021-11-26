package com.example.ex1.exceptions;

public class NoProductFoundException extends RuntimeException{
    public  NoProductFoundException(String message) {
        super(message);
    }
}
