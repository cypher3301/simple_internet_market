package com.example.internet_market.service.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class MarketException extends IllegalStateException{
    private String message;
    private String fieldException;
    private int codeError;

    public MarketException(String message) {
        this.message = message;
    }
}
