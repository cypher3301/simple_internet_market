package com.example.internet_market.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
public class Provider {
    @Id
//    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String name;



    @OneToMany(mappedBy = "provider")
    private List<Item> itemsProvide = new ArrayList<>();

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Provider)) return false;

        Provider provider = (Provider) o;

        if (getId() != null ? !getId().equals(provider.getId()) : provider.getId() != null) return false;
        return getName() != null ? getName().equals(provider.getName()) : provider.getName() == null;
    }

    @Override
    public int hashCode() {
        int result = getId() != null ? getId().hashCode() : 0;
        result = 31 * result + (getName() != null ? getName().hashCode() : 0);
        return result;
    }
}
