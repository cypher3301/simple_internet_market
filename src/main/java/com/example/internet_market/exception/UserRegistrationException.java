package com.example.internet_market.exception;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@EqualsAndHashCode(callSuper = false)
public class UserRegistrationException extends MarketException{
    private String message;
    private String fieldException;
    private int codeError;

}
