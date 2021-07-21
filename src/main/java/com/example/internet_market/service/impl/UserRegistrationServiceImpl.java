package com.example.internet_market.service.impl;

import com.example.internet_market.entity.Basket;
import com.example.internet_market.entity.User;
import com.example.internet_market.exception.UserRegistrationException;
import com.example.internet_market.repository.BasketRepository;
import com.example.internet_market.repository.UserRepository;
import com.example.internet_market.service.UserRegistrationService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@AllArgsConstructor
public class UserRegistrationServiceImpl implements UserRegistrationService {
    private UserRepository userRepository;
    private BasketRepository basketRepository;
    private UserRegistrationException userRegistrationException;

    @Override
    public User saveUser(User user) throws UserRegistrationException {
        if (checkUser(user)) {
                Basket basket = new Basket();
                basket.setUser(user);
                user.setBasket(basket);
                user.setId((long) user.hashCode());
                basket.setId(user.getId());
        }

        return null;
    }

    private User sendUserWithBasketToDB(User user){
        return userRepository.save(user);
    }

    private boolean checkUser(User user) throws UserRegistrationException {
        if (user == null)
            throw new UserRegistrationException("User cannot be null");
        if (user.getEmail() == null || user.getEmail().isEmpty())
            throw new UserRegistrationException("Email cannot be empty");
        if (user.getAddress() == null || user.getAddress().isEmpty())
            throw new UserRegistrationException("Address cannot be empty");
        if (user.getName() == null || user.getName().isEmpty())
            throw new UserRegistrationException("Name cannot be empty");
        if (user.getPhone() == null || user.getPhone().isEmpty())
            throw new UserRegistrationException("Phone cannot be empty");

        if(!userRepository.existsByEmail(user.getEmail()))
            throw new UserRegistrationException("Email is already exists");
        if(!userRepository.existsByPhone(user.getPhone()))
            throw new UserRegistrationException("Phone is already exists");
        return true;
    }

}
