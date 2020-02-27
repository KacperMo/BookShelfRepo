package pl.pirakaco.pp5.ebooks.productcatalog;

import lombok.*;
import pl.pirakaco.pp5.ebooks.productcatalog.dto.ProductData;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.math.BigDecimal;



@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Builder
public class Product {
    @Id
    @GeneratedValue
    Long id;

    String eBookTitle;
    String eBookDescription;
    String authorFirstName;
    String authorLastName;
    BigDecimal price;
    Boolean published;
    String cover;



    public ProductData toData() {
        return new ProductData(id, eBookTitle, price);
    }

}
