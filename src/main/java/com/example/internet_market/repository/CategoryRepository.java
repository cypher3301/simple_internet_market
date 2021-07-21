package com.example.internet_market.repository;

import com.example.internet_market.entity.Category;
import com.example.internet_market.entity.Provider;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Long> {
}
