package com.example.internet_market.repository;

import com.example.internet_market.entity.Basket;
import com.example.internet_market.entity.Provider;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BasketRepository extends JpaRepository<Basket, Long> {
}
