package com.example.internet_market.service;

import com.example.internet_market.entity.Category;

import java.util.List;

public interface CategoryService {
    
    Category save();

    Category deleteById();
    Category deleteByName();
    
    Category findById();
    List<Category> findByName();
    List<Category> findByAll();

    Category change();
}
