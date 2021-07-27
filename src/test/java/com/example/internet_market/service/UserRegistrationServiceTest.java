package com.example.internet_market.service;

import com.example.internet_market.Utility;
import com.example.internet_market.entity.User;
import com.example.internet_market.service.exception.UserRegistrationException;
import com.example.internet_market.repository.BasketRepository;
import com.example.internet_market.repository.UserRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Objects;

@SpringBootTest
public class UserRegistrationServiceTest {
    @Autowired
    private UserRegistrationService userRegistrationService;
    @Autowired
    private BasketRepository basketRepository;
    @Autowired
    private UserRepository userRepository;
    private final User user = new Utility().generateUser();

    @Test
    void register() {
        User savedUser = userRegistrationService.register(user);
//        User savedUser = userRepository.save(user);
        assert savedUser.equals(user);
        assert Objects.equals(savedUser.getId(), user.getId());
        if (userRepository.existsById(user.getId())){
            basketRepository.deleteById(user.getId());
            userRepository.deleteById(user.getId());
        }
    }

    @Test
    void registrationUserNull() {
        User localUser = null;
        try {
            userRegistrationService.register(localUser);
        } catch (UserRegistrationException e) {
            assert e.getFieldException().equals("user");
            System.out.println(e.toString());
            return;
        }
        assert false;
    }

    @Test
    void registrationIdNullOrEmpty() {
        User localUser = user;
        User userRegistered;
        localUser.setId(null);
        try {
            userRegistered = userRegistrationService.register(localUser);
        } catch (UserRegistrationException e) {
            System.out.println(e.toString());
            assert false;
            return;
        }
        assert userRegistered != null;
        assert userRegistered.hashCode() == localUser.hashCode();
        assert userRegistered.getId() == localUser.hashCode();
        basketRepository.deleteById(userRegistered.getId());
        userRepository.deleteById(userRegistered.getId());
    }

    @Test
    void registrationNameNull() {
        User localUser = user;
        localUser.setName(null);
        try {
            userRegistrationService.register(localUser);
        } catch (UserRegistrationException e) {
            assert e.getFieldException().equals("name");
            System.out.println(e.toString());
            return;
        }
        assert false;
    }

    @Test
    void registrationNameEmpty() {
        User localUser = user;
        localUser.setName("");
        try {
            userRegistrationService.register(localUser);
        } catch (UserRegistrationException e) {
            assert e.getFieldException().equals("name");
            System.out.println(e.toString());
            return;
        }
        assert false;
    }

    @Test
    void registrationAddressNull() {
        User localUser = user;
        localUser.setAddress(null);
        try {
            userRegistrationService.register(localUser);
        } catch (UserRegistrationException e) {
            assert e.getFieldException().equals("address");
            System.out.println(e.toString());
            return;
        }
        assert false;
    }

    @Test
    void registrationAddressEmpty() {
        User localUser = user;
        localUser.setAddress("");
        try {
            userRegistrationService.register(localUser);
        } catch (UserRegistrationException e) {
            assert e.getFieldException().equals("address");
            System.out.println(e.toString());
            return;
        }
        assert false;
    }

    @Test
    void registrationEmailNull() {
        User localUser = user;
        localUser.setEmail(null);
        try {
            userRegistrationService.register(localUser);
        } catch (UserRegistrationException e) {
            assert e.getFieldException().equals("email");
            System.out.println(e.toString());
            return;
        }
        assert false;
    }

    @Test
    void registrationEmailEmpty() {
        User localUser = user;
        localUser.setEmail("");
        try {
            userRegistrationService.register(localUser);
        } catch (UserRegistrationException e) {
            assert e.getFieldException().equals("email");
            System.out.println(e.toString());
            return;
        }
        assert false;
    }

    @Test
    void registrationEmailExists() {
        user.setPhone(user.getPhone().replace("1", "2"));
        try {
            userRegistrationService.register(user);
        } catch (UserRegistrationException e) {
            assert e.getFieldException().equals("email");
            System.out.println(e.toString());
            return;
        }
        assert false;
    }

    @Test
    void registrationPhoneNull() {
        User localUser = user;
        localUser.setPhone("");
        try {
            userRegistrationService.register(localUser);
        } catch (UserRegistrationException e) {
            assert e.getFieldException().equals("phone");
            System.out.println(e.toString());
            return;
        }
        assert false;
    }

    @Test
    void registrationPhoneEmpty() {
        User localUser = user;
        localUser.setPhone("");
        try {
            userRegistrationService.register(localUser);
        } catch (UserRegistrationException e) {
            assert e.getFieldException().equals("phone");
            System.out.println(e.toString());
            return;
        }
        assert false;
    }

    @Test
    void registrationPhoneExists() {
        User localUser = user;
        localUser.setEmail("1" + user.getEmail());
        try {
            userRegistrationService.register(localUser);
        } catch (UserRegistrationException e) {
            assert e.getFieldException().equals("phone");
            System.out.println(e.toString());
            return;
        }
        assert false;
    }

}
