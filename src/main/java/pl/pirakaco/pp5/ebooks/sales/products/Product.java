package pl.pirakaco.pp5.ebooks.sales.products;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
public class Product {
    private String productId;
    private BigDecimal price;
    private Integer quantity;

    public Product(String productId, BigDecimal price) {
        this.productId = productId;
        this.price = price;
        this.quantity = 1;
    }

    public Product(String productId, int price) {
        this.productId = productId;
        this.price = BigDecimal.valueOf(price);
        this.quantity = 1;
    }
}
