package com.example.internet_market.entity;

import com.example.internet_market.entity.transientTable.ItemBasket;
import lombok.Data;

import javax.persistence.*;
import java.util.Collection;

@Entity
@Data
public class Basket {
    @Id
    private Long id;

    @OneToOne
    @JoinColumn(name = "user_id",referencedColumnName = "id",updatable = false)
    private User user;

    @OneToMany(mappedBy = "basket")
    private Collection<ItemBasket> basketItem;
}
