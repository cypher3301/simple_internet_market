package com.example.internet_market.service;

import com.example.internet_market.entity.Basket;
import com.example.internet_market.entity.User;
import com.example.internet_market.exception.UserRegistrationException;

public interface UserRegistrationService {
    User saveUser(User user) throws UserRegistrationException;
}
