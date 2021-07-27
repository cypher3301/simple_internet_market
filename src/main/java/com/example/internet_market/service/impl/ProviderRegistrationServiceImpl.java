/*
 * %W% %E% name lastname
 * Copyright (c) ...
 * license
 */
package com.example.internet_market.service.impl;

import com.example.internet_market.entity.Provider;
import com.example.internet_market.repository.ProviderRepository;
import com.example.internet_market.service.ProviderRegistrationService;
import com.example.internet_market.service.exception.ProviderRegistrationException;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class ProviderRegistrationServiceImpl implements ProviderRegistrationService {
    private ProviderRepository providerRepository;

    @Override
    public Provider register(Provider provider) throws ProviderRegistrationException {
        if (provider!=null){
            if (provider.getId() == null) {
                provider.setId((long) provider.hashCode());
            }
            return providerRepository.save(provider);
        }
        throw new ProviderRegistrationException();

    }
}
