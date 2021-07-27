package com.example.internet_market.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.Collection;
import java.util.Map;

@Entity(name = "order")
@Table(name = "order")
@Data
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false, unique = true, updatable = false)
    private Long id;

    private boolean cancel = false;

    @ManyToOne
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    private User user;

    @OneToMany
    private Collection<Item> items;
}
