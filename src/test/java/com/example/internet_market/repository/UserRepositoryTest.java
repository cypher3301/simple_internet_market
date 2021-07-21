package com.example.internet_market.repository;

import com.example.internet_market.entity.User;
import org.hibernate.Session;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Bean;
import org.springframework.util.Assert;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.transaction.Transactional;
import java.util.Objects;

@SpringBootTest
public class UserRepositoryTest {

    @Autowired
    private UserRepository userRepository;

    User user = generateUser();


    @Test
    void saveUser() {
        User userRepositoryAnswer = userRepository.save(user);
        User userFindBy = userRepository.findByEmail(user.getEmail());


        assert Objects.equals(user.getId(), userRepositoryAnswer.getId()) && Objects.equals(user.getId(), userFindBy.getId());
        assert (!Objects.requireNonNull(userFindBy.getName()).isEmpty());
        assert (!Objects.requireNonNull(userFindBy.getPhone()).isEmpty());
        assert (!Objects.requireNonNull(userFindBy.getEmail()).isEmpty());
        assert (!Objects.requireNonNull(userFindBy.getAddress()).isEmpty());
    }

    @Test
    void updateUser() {
        User userFromDbByEmail = userRepository.findByEmail(user.getEmail());
        userFromDbByEmail.setName("abc");
        User userSaved = userRepository.save(userFromDbByEmail);

        assert (!Objects.equals(user.getName(), userSaved.getName()));
        assert Objects.equals(userSaved.getName(), "abc");
    }

    @Test
    void deleteUser() {
        userRepository.deleteById(user.getId());
        assert !userRepository.findById(user.getId()).isPresent();
    }

    private User generateUser() {
        User user = new User();
        user.setId(999_999_999L);
        user.setName("abcdefghijklmnoprstuvwxyz");
        user.setEmail("abcdefghijklmnoprstuvw@xyz.com");
        user.setAddress("123, abcdefghijkl mnoprstuvwxyz");
        user.setPhone("+123 (45) 678 90 00");
        return user;
    }
}
