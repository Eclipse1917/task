package com.example.backend.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class BnkseekNotFound extends RuntimeException {
    public BnkseekNotFound() {
    }

    public BnkseekNotFound(String message) {
        super(message);
    }

    public BnkseekNotFound(String message, Throwable cause) {
        super(message, cause);
    }

    public BnkseekNotFound(Throwable cause) {
        super(cause);
    }

    public BnkseekNotFound(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
