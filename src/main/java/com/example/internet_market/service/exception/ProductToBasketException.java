package com.example.internet_market.service.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
public class ProductToBasketException extends MarketException{
    public ProductToBasketException(String message, String fieldException, int codeError) {
        super(message, fieldException, codeError);
    }

    public ProductToBasketException(String message) {
        super(message);
    }
}
