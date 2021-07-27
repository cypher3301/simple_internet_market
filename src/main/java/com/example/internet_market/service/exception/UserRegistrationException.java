package com.example.internet_market.service.exception;

import lombok.*;

@AllArgsConstructor
@EqualsAndHashCode(callSuper = false)
@Data
public class UserRegistrationException extends MarketException{
    public UserRegistrationException(String message, String fieldException, int codeError) {
        super(message, fieldException, codeError);
    }
}
