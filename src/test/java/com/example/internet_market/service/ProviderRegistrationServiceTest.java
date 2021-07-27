package com.example.internet_market.service;

import com.example.internet_market.Utility;
import com.example.internet_market.entity.Provider;
import com.example.internet_market.repository.ProviderRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Objects;

@SpringBootTest
public class ProviderRegistrationServiceTest {
    @Autowired
    private ProviderRegistrationService providerRegistrationService;
    private final Provider provider = new Utility().generateProvider();
    @Autowired
    private ProviderRepository providerRepository;

    @Test
    void register() {
        Provider savedProvider = providerRegistrationService.register(provider);
        assert savedProvider.equals(provider);
        assert Objects.equals(savedProvider.getId(), provider.getId());
        if (providerRepository.existsById(provider.getId())){
            providerRepository.deleteById(provider.getId());
        }
    }
}
