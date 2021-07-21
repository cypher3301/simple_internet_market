package com.example.internet_market.repository;

import com.example.internet_market.entity.Provider;
import com.example.internet_market.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    boolean existsByEmail(String email);
    boolean existsByPhone(String email);
}
