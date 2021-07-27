package com.example.internet_market.service.exception;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;

@AllArgsConstructor
@EqualsAndHashCode(callSuper = false)
@Data
public class ProviderRegistrationException extends MarketException {
    public ProviderRegistrationException(String message, String fieldException, int codeError) {
        super(message, fieldException, codeError);
    }
}
