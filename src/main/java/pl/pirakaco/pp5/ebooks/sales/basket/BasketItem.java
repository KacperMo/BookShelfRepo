package pl.pirakaco.pp5.ebooks.sales.basket;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.math.BigDecimal;

@Getter
@AllArgsConstructor
public class BasketItem {
    private String id;
    private Integer quantity;
    private BigDecimal price;

    public BasketItem(String id, Integer quantity, double price) {
        this.id = id;
        this.quantity = quantity;
        this.price = BigDecimal.valueOf(price);
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }
}
