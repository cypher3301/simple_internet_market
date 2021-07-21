package com.example.internet_market.entity;

import lombok.Data;
import org.aspectj.weaver.ast.Or;

import javax.persistence.*;
import java.util.Collection;

@Entity
@Data
public class User {
    @Id
//    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String name;
    private String email;
    private String phone;
    private String address;


    @OneToOne(mappedBy = "user", cascade = CascadeType.ALL)
    private Basket basket;


    @OneToMany(mappedBy = "user")
    private Collection<Order> orders;


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof User)) return false;

        User user = (User) o;

        if (getName() != null ? !getName().equals(user.getName()) : user.getName() != null) return false;
        if (getEmail() != null ? !getEmail().equals(user.getEmail()) : user.getEmail() != null) return false;
        return getPhone() != null ? getPhone().equals(user.getPhone()) : user.getPhone() == null;
    }

    @Override
    public int hashCode() {
        int result = getName() != null ? getName().hashCode() : 0;
        result = 31 * result + (getEmail() != null ? getEmail().hashCode() : 0);
        result = 31 * result + (getPhone() != null ? getPhone().hashCode() : 0);
        return result;
    }
}
