package pl.pirakaco.pp5.ebooks.productcatalog;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import pl.pirakaco.pp5.ebooks.productcatalog.dto.ProductData;
import pl.pirakaco.pp5.ebooks.productcatalog.exceptions.NoSuchProductException;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.math.BigDecimal;

@SpringBootTest
@RunWith(SpringRunner.class)
public class CatalogTest {
    public static final String PRODUCT_NAME = "my product";
    public static final Long ID = 10L;

    @Autowired
    ProductCatalogRepository productCatalogRepository;

    @Autowired
    ProductCatalogFacade productCatalogFacade;

    @Before
    void setup() {
        productCatalogRepository.deleteAll();
    }

    @Test
    public void itAllowsToLoadSingleProduct() {
        Product product = thereIsAProduct();

        Long idProduct = productCatalogFacade.create(product);

        ProductData loaded = productCatalogFacade.load(idProduct);

        assertThat(loaded.getId()).isEqualTo(idProduct);
    }

    @Test
    public void exceptionWhenNotExistingProductIsLoaded() {
        assertThatThrownBy(() -> {
            productCatalogFacade.load(ID);
        }).isInstanceOf(NoSuchProductException.class);
    }

    private Product thereIsAProduct() {
        return Product.builder()
                .eBookTitle(PRODUCT_NAME)
                .eBookDescription("fajnty")
                .price(BigDecimal.valueOf(23432))
                .published(true)
                .authorFirstName("Ktos")
                .authorLastName("Nazwisko")
                .build();
    }
}
