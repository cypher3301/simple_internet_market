package com.example.internet_market.repository;

import com.example.internet_market.entity.Item;
import com.example.internet_market.entity.Provider;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ItemRepository extends JpaRepository<Item, Long> {
}
