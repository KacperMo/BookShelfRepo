package pl.pirakaco.pp5.ebooks.sales.basket;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
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
}
