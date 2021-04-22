package com.switchfully.spaceshark.customExeptions;

public class CategoryNotValidException extends RuntimeException {

    public CategoryNotValidException(String message) {
        super(message);
    }
}
