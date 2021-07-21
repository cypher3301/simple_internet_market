package com.example.internet_market.entity.pk;

import javax.persistence.Column;
import javax.persistence.Id;
import java.io.Serializable;

public class ItemBasketPK implements Serializable {
    @Id
    @Column(name = "item_id",nullable = false)
    private long itemId;
    @Id
    @Column(name = "basket_id",nullable = false)
    private long basketId;


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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ItemBasketPK)) return false;

        ItemBasketPK that = (ItemBasketPK) o;

        if (itemId != that.itemId) return false;
        return basketId == that.basketId;
    }

    @Override
    public int hashCode() {
        int result = (int) (itemId ^ (itemId >>> 32));
        result = 31 * result + (int) (basketId ^ (basketId >>> 32));
        return result;
    }
}
