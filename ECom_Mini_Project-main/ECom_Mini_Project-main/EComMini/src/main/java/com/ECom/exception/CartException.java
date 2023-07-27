package com.ECom.exception;

public class CartException extends RuntimeException{
    public CartException() {
    }

    public CartException(String message) {
        super(message);
    }
}
