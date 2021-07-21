package com.example.internet_market.entity.transientTable;

import com.example.internet_market.entity.Basket;
import com.example.internet_market.entity.Item;
import com.example.internet_market.entity.pk.ItemBasketPK;

import javax.persistence.*;

@Entity
@Table(name = "item_basket")
@IdClass(ItemBasketPK.class)
public class ItemBasket {

    @Id
    @Column(name = "item_id",nullable = false)
    private long itemId;
    @Id
    @Column(name = "basket_id",nullable = false)
    private long basketId;

    @ManyToOne
    @JoinColumn(name = "item_id",referencedColumnName = "id",nullable = false, insertable = false,updatable = false)
    private Item item;

    @ManyToOne
    @JoinColumn(name = "basket_id",referencedColumnName = "id",nullable = false, insertable = false,updatable = false)
    private Basket basket;


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ItemBasket)) return false;

        ItemBasket that = (ItemBasket) o;

        if (itemId != that.itemId) return false;
        return basketId == that.basketId;
    }

    @Override
    public int hashCode() {
        int result = (int) (itemId ^ (itemId >>> 32));
        result = 31 * result + (int) (basketId ^ (basketId >>> 32));
        return result;
    }

    public long getItemId() {
        return itemId;
    }

    public void setItemId(long itemId) {
        this.itemId = itemId;
    }

    public long getBasketId() {
        return basketId;
    }

    public void setBasketId(long basketId) {
        this.basketId = basketId;
    }

    public Item getItem() {
        return item;
    }

    public void setItem(Item item) {
        this.item = item;
    }

    public Basket getBasket() {
        return basket;
    }

    public void setBasket(Basket basket) {
        this.basket = basket;
    }
}
