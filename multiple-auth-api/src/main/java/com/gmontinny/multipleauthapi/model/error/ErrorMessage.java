package com.gmontinny.multipleauthapi.model.error;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.gmontinny.multipleauthapi.config.CustomDateSerializer;
import lombok.Data;
import org.springframework.http.HttpStatus;

import java.time.LocalDateTime;

@Data
public class ErrorMessage {
    @JsonSerialize(using = CustomDateSerializer.class)
    private LocalDateTime time = LocalDateTime.now();

    private String message;

    private HttpStatus httpStatus;

    public ErrorMessage(String message, HttpStatus httpStatus) {
        this.message = message;
        this.httpStatus = httpStatus;
    }
}
