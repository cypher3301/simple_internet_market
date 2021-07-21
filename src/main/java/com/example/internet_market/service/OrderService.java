package com.example.internet_market.service;

import com.example.internet_market.entity.Order;

import java.util.List;

public interface OrderService {

    Order save();

    Order deleteById();
    Order deleteByName();

    Order findById();
    List<Order> findByName();
    List<Order> findByAll();

    Order change();
}
