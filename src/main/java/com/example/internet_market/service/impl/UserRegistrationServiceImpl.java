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
@Transactional
public class UserRegistrationServiceImpl implements UserRegistrationService {
    private UserRepository userRepository;

    @Override
    public User registration(User user) throws UserRegistrationException {
        if (checkUser(user)) {
                Basket basket = new Basket();
                basket.setUser(user);
                user.setBasket(basket);
                user.setId((long) user.hashCode());
                basket.setId(user.getId());
                return sendUserWithBasketToDB(user);
        }
        return null;
    }

    private User sendUserWithBasketToDB(User user){
        return userRepository.save(user);
    }


    private boolean checkUser(User user) throws UserRegistrationException {
        if (user == null)
            throw new UserRegistrationException("User cannot be null","user",1);
        if (user.getEmail() == null || user.getEmail().isEmpty())
            throw new UserRegistrationException("Email cannot be empty","email",2);
        if (user.getAddress() == null || user.getAddress().isEmpty())
            throw new UserRegistrationException("Address cannot be empty","address", 3);
        if (user.getName() == null || user.getName().isEmpty())
            throw new UserRegistrationException("Name cannot be empty","name",4);
        if (user.getPhone() == null || user.getPhone().isEmpty())
            throw new UserRegistrationException("Phone cannot be empty","phone",5);

        if(!userRepository.existsByEmail(user.getEmail()))
            throw new UserRegistrationException("Email is already exists","email",2);
        if(!userRepository.existsByPhone(user.getPhone()))
            throw new UserRegistrationException("Phone is already exists","phone",5);
        return true;
    }

}
