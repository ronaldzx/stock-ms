package com.everis.stockms.exception;

import lombok.Getter;

import java.time.Instant;

@Getter
public class BusinessException extends Exception {

    private static final long serialVersionUID = 1L;
    private String message;
    private Instant date;

    public BusinessException(String message) {
        this.message = message;
        this.date = Instant.now();
    }
}
