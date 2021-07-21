package com.example.internet_market.repository;

import com.example.internet_market.entity.Order;
import com.example.internet_market.entity.Provider;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderRepository extends JpaRepository<Order, Long> {
}
