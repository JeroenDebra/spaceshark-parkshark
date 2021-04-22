package com.switchfully.spaceshark.customExeptions;

public class CurrencyNotValidException extends RuntimeException{

    public CurrencyNotValidException(String message) {
        super(message);
    }
}
