package com.example.internet_market.service;

import com.example.internet_market.entity.Provider;

import java.util.List;

public interface ProviderService {

    Provider save();

    Provider deleteById();
    Provider deleteByName();

    Provider findById();
    List<Provider> findByName();
    List<Provider> findAll();


    Provider change();
}
