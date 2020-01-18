package pl.pirakaco.pp5.ebooks.productcatalog.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@NoArgsConstructor
@Data
public class ProductData {
    String id;
    String eBookName;
    BigDecimal price;

    public ProductData(String id, String eBookName, BigDecimal price) {
        this.id = id;
        this.eBookName = eBookName;
        this.price = price;
    }
}
