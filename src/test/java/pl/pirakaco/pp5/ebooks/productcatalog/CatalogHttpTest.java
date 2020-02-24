package pl.pirakaco.pp5.ebooks.productcatalog;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;
import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@RunWith(SpringRunner.class)
public class CatalogHttpTest {

    public static final String PRODUCT_NAME = "product1";
    @Autowired
    TestRestTemplate restTemplate;

    @Autowired
    ProductCatalogFacade productCatalogFacade;

    @Autowired
    ProductCatalogRepository productCatalogRepository;

    @LocalServerPort
    int port;

    @Before
    void setup() {
        productCatalogRepository.deleteAll();
    }

    @Test
    public void itAllowsToCreateProducts() {
        Product product = thereIsProduct();

        productCatalogFacade.create(product);

        ResponseEntity<Product[]> response = restTemplate.getForEntity(getUrl("/api/products"), Product[].class);

        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
        assertThat(response.getBody()).hasSize(1);
        assertThat(Arrays.stream(response.getBody())
        .map(Product::getEBookTitle))
                .contains(PRODUCT_NAME);
    }

    @Test
    public void itDoesNotListProducts() {
        Product product = thereIsProduct();
        productCatalogFacade.create(product);
        ResponseEntity<Product[]> response = restTemplate.getForEntity(getUrl("/api/products"), Product[].class);

        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
        assertThat(response.getBody()).hasSize(0);
    }


    private String getUrl(String uri) {
        return String.format("http://localhost:%s/%s", port, uri);
    }

    private Product thereIsProduct() {
        return Product.builder()
                .eBookTitle(PRODUCT_NAME)
                .eBookDescription("fajny ebook")
                .price(BigDecimal.valueOf(19))
                .authorFirstName("Ktos")
                .authorLastName("Nazwisko")
                .published(true)
                .build();
    }
}
