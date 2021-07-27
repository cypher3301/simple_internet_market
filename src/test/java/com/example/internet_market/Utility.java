package com.example.internet_market;

import com.example.internet_market.entity.Provider;
import com.example.internet_market.entity.User;

public class Utility {
    public User generateUser() {
        User user = new User();
        user.setId(999_999_999L);
        user.setName("abcdefghijklmnoprstuvwxyz");
        user.setEmail("abcdefghijklmnoprstuvw@xyz.com");
        user.setAddress("123, abcdefghijkl mnoprstuvwxyz");
        user.setPhone("+123 (45) 678 90 00");
        return user;
    }

    public Provider generateProvider(){
        Provider provider = new Provider();
        provider.setId(999_999_999L);
        provider.setName("abcdefghijklmnoprstuvwxyz");
        return provider;
    }
}
