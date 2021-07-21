package com.example.internet_market.service;

import com.example.internet_market.entity.Item;

import java.util.List;

public interface ItemService {

    Item save();

    Item deleteById();
    Item deleteByName();

    Item findById();
    List<Item> findByName();
    List<Item> findByAll();

    Item change();
}
