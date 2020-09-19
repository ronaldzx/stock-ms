package com.everis.stockms.utils;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.Instant;

@Getter
@AllArgsConstructor
public class ErrorDetail {
    private String message;
    private Instant date;
}
