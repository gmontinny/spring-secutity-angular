package com.gmontinny.multipleauthapi.model.error;

public class OAuth2AuthenticationProcessingException extends RuntimeException  {
    public OAuth2AuthenticationProcessingException(String message) {
        super(message);
    }
}
