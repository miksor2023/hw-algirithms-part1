package org.example.exceptions;

public class ItemNotFoundExeption extends RuntimeException{
    public ItemNotFoundExeption() {
    }

    public ItemNotFoundExeption(String message) {
        super(message);
    }

    public ItemNotFoundExeption(String message, Throwable cause) {
        super(message, cause);
    }

    public ItemNotFoundExeption(Throwable cause) {
        super(cause);
    }

    public ItemNotFoundExeption(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
