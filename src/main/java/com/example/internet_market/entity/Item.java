package com.example.internet_market.entity;

import com.example.internet_market.entity.transientTable.ItemBasket;
import lombok.Data;

import javax.persistence.*;
import java.util.Collection;

@Entity
@Data
public class Item {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    
    private String name;
    private Double cost;
    private String description;

    @ManyToOne
    @JoinColumn(name = "provider_id", referencedColumnName = "id")
    private Provider provider;

    @ManyToOne
    @JoinColumn(name = "category_id", referencedColumnName = "id")
    private Category category;

    @OneToMany(mappedBy = "item")
    private Collection<ItemBasket> itemBasket;
}
