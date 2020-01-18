package pl.pirakaco.pp5.ebooks.productcatalog;

import lombok.*;
import pl.pirakaco.pp5.ebooks.productcatalog.dto.ProductData;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.math.BigDecimal;

import java.util.Date;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Builder
public class Product {
    @Id
    @GeneratedValue
    private String id;

    private String eBookName;
    private String authorFirstName;
    private String authorLastName;
    private BigDecimal price;
    private String format;
    private String description;
    private String publishingHouse;
    private String fileSize;
    private String ISBN;
    private Date releaseDate;


    public ProductData toData() {
        return new ProductData(id, eBookName, price);
    }

}
