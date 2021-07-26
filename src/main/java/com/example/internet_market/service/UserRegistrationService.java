/*
 * %W% %E% name lastname
 * Copyright (c) ...
 * license
 */
package com.example.internet_market.service;

import com.example.internet_market.entity.Basket;
import com.example.internet_market.entity.User;
import com.example.internet_market.exception.UserRegistrationException;

/**
 * This interface UserRegistrationService responsible for registration users
 * @version 1.00 21 Jun 2021
 * @author name lastname
 */
public interface UserRegistrationService {

    /**
     * Registration of users make in registration method
     * @param user whose will be registered
     * @return user object from database whose was registered
     *
     * @throws UserRegistrationException if the specified object null
     * or object fields is empty
     */
    User registration(User user) throws UserRegistrationException;
}
