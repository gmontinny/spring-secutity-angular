package com.gmontinny.multipleauthapi.model.error;

public class BadCredentialsException extends RuntimeException {
    public BadCredentialsException(String message) {
        super(message);
    }
}
