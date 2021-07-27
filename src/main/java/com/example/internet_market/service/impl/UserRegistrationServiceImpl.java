/*
 * %W% %E% name lastname
 * Copyright (c) ...
 * license
 */
package com.example.internet_market.service.impl;

import com.example.internet_market.entity.Basket;
import com.example.internet_market.entity.User;
import com.example.internet_market.exception.UserRegistrationException;
import com.example.internet_market.repository.UserRepository;
import com.example.internet_market.service.UserRegistrationService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

/**
 * This class implements user service registration interface
 */
@Service
@AllArgsConstructor
@Transactional
public class UserRegistrationServiceImpl implements UserRegistrationService {
    private UserRepository userRepository;

    /**
     * Registration of users make in registration method
     *
     * @param user whose will be registered
     * @return user object from database whose was registered
     * @throws UserRegistrationException if the specified object null
     *                                   or object fields is empty
     */
    @Override
    public User registration(User user) throws UserRegistrationException {
        if (checkUser(user)) {
            Basket basket = new Basket();
            basket.setUser(user);
            user.setBasket(basket);
            if (user.getId()==null){
                user.setId((long) user.hashCode());
            }
            basket.setId(user.getId());
            return userRepository.save(user);
        }
        throw new UserRegistrationException();
    }

    /**
     * Check every User field on null or empty, and existing check email and phone
     *
     * @param user for check
     * @return true if user properties not null or not empty without id, id can be null here
     * @throws UserRegistrationException if any property null or empty, or email or phone exists in database
     */
    public boolean checkUser(User user) throws UserRegistrationException {
        if (user == null) {
            throw new UserRegistrationException("User cannot be null", "user", 1);
        }
        if ((user.getEmail() == null) || user.getEmail().isEmpty()) {
            throw new UserRegistrationException("Email cannot be empty", "email", 2);
        }
        if ((user.getAddress() == null) || user.getAddress().isEmpty()) {
            throw new UserRegistrationException("Address cannot be empty", "address", 3);
        }
        if ((user.getName() == null) || user.getName().isEmpty()) {
            throw new UserRegistrationException("Name cannot be empty", "name", 4);
        }
        if ((user.getPhone() == null) || user.getPhone().isEmpty()) {
            throw new UserRegistrationException("Phone cannot be empty", "phone", 5);
        }

        if (userRepository.existsByEmail(user.getEmail())) {
            throw new UserRegistrationException("Email is already exists", "email", 2);
        }
        if (userRepository.existsByPhone(user.getPhone())) {
            throw new UserRegistrationException("Phone is already exists", "phone", 5);
        }
//        if (userRepository.existsByEmailOrPhone(user.getEmail(), user.getPhone())){
//            throw new UserRegistrationException("Phone or Email is already exists", "phone or email", 25);
//        }
        return true;
    }

}
