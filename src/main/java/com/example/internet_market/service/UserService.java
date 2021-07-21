package com.example.internet_market.service;

import com.example.internet_market.entity.Basket;
import com.example.internet_market.entity.User;

import java.util.List;

public interface UserService {

    User save();

    User deleteById();
    User deleteByName();

    User findById();
    List<User> findByName();
    User findByEmail();
    List<User> findByAll();


    User change();
}
