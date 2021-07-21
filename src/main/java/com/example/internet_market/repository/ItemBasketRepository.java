package com.example.internet_market.repository;

import com.example.internet_market.entity.Provider;
import com.example.internet_market.entity.transientTable.ItemBasket;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ItemBasketRepository extends JpaRepository<ItemBasket, Long> {
}
