package pl.pirakaco.pp5.ebooks.productcatalog.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@NoArgsConstructor
@Data
public class ProductData {
    String id;
    String eBookTitle;
    BigDecimal price;

    public ProductData(String id, String eBookTitle, BigDecimal price) {
        this.id = id;
        this.eBookTitle = eBookTitle;
        this.price = price;
    }
}
