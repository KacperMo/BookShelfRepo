package pl.pirakaco.pp5.ebooks.sales;

import java.math.BigDecimal;

public class Product {
    private long productId;
    private BigDecimal price;
    private Integer quantity;

    public Product(long productId, BigDecimal price) {
        this.productId = productId;
        this.price = price;
        this.quantity = 1;
    }

    public long getProductId() {
        return productId;
    }

    public void setProductId(long productId) {
        this.productId = productId;
    }
}
