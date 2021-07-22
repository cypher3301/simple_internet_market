package com.example.internet_market.service;

import com.example.internet_market.Utility;
import com.example.internet_market.entity.User;
import com.example.internet_market.exception.UserRegistrationException;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class UserRegistrationServiceTest {
    @Autowired
    private UserRegistrationService userRegistrationService;
    private final User user = new Utility().generateUser();

    @Test
    void registrationUserNull() {
        User localUser = null;
        try {
            userRegistrationService.registration(localUser);
        } catch (UserRegistrationException e) {
            assert e.getFieldException().equals("user");
            return;
        }
        assert false;
    }

    @Test
    void registrationEmailNull() {
        User localUser = user;
        localUser.setEmail(null);
        try {
            userRegistrationService.registration(localUser);
        } catch (UserRegistrationException e) {
            assert e.getFieldException().equals("email");
            return;
        }
        assert false;
    }

    @Test
    void registrationEmailEmpty() {
        User localUser = user;
        localUser.setEmail("");
        try {
            userRegistrationService.registration(localUser);
        } catch (UserRegistrationException e) {
            assert e.getFieldException().equals("email");
            return;
        }
        assert false;
    }

    @Test
    void registrationAddressNull() {
        User localUser = user;
        localUser.setAddress(null);
        try {
            userRegistrationService.registration(localUser);
        } catch (UserRegistrationException e) {
            assert e.getFieldException().equals("address");
            return;
        }
        assert false;
    }

    @Test
    void registrationAddressEmpty() {
        User localUser = user;
        localUser.setAddress("");
        try {
            userRegistrationService.registration(localUser);
        } catch (UserRegistrationException e) {
            assert e.getFieldException().equals("address");
            return;
        }
        assert false;
    }

    @Test
    void registrationNameNull() {
        User localUser = user;
        localUser.setName(null);
        try {
            userRegistrationService.registration(localUser);
        } catch (UserRegistrationException e) {
            assert e.getFieldException().equals("name");
            return;
        }
        assert false;
    }

    @Test
    void registrationNameEmpty() {
        User localUser = user;
        localUser.setName("");
        try {
            userRegistrationService.registration(localUser);
        } catch (UserRegistrationException e) {
            assert e.getFieldException().equals("name");
            return;
        }
        assert false;
    }

    @Test
    void registrationPhoneNull() {
        User localUser = user;
        localUser.setPhone("");
        try {
            userRegistrationService.registration(localUser);
        } catch (UserRegistrationException e) {
            assert e.getFieldException().equals("phone");
            return;
        }
        assert false;
    }

    @Test
    void registrationPhoneEmpty() {
        User localUser = user;
        localUser.setPhone("");
        try {
            userRegistrationService.registration(localUser);
        } catch (UserRegistrationException e) {
            assert e.getFieldException().equals("phone");
            return;
        }
        assert false;
    }

}
