package com.example.internet_market.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Entity
@Data
@Table(name = "category")
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String name;

    @OneToMany(mappedBy = "category")
    private Collection<Category> categories;

    @ManyToOne
    @JoinColumn(name = "subcategory", referencedColumnName = "id")
    private Category category;

    @OneToMany(mappedBy = "category")
    private Collection<Item> items;
}
