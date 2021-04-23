package com.switchfully.spaceshark.customExeptions;

public class NotAuthorizedException extends RuntimeException{

    public NotAuthorizedException(String message) {
        super(message);
    }
}
