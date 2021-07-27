/*
 * %W% %E% name lastname
 * Copyright (c) ...
 * license
 */
package com.example.internet_market.service;

import com.example.internet_market.entity.Provider;
import com.example.internet_market.service.exception.ProviderRegistrationException;

/**
 * This interface ProviderRegistrationService responsible for registration providers
 * @version 1.00 21 Jun 2021
 * @author name lastname
 */
public interface ProviderRegistrationService {
    /**
     * Provider registration , an id will be generated or provider already has an id
     *
     * @param provider entity, name must be required
     * @exception ProviderRegistrationException has massage, exception target or name nad exception code
     */
    Provider register(Provider provider) throws ProviderRegistrationException;
}
