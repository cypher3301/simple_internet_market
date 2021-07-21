package com.example.internet_market.service;

import com.example.internet_market.entity.Basket;
import com.example.internet_market.entity.Item;

import java.util.List;

public interface BasketService {

    Basket save();

    Basket deleteById();
    Basket deleteByName();

    Basket findById();

    Basket change();
}
