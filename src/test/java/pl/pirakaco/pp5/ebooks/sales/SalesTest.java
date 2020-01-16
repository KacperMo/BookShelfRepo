package pl.pirakaco.pp5.ebooks.sales;

import org.junit.Before;
import org.junit.Test;

import java.math.BigDecimal;
import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

public class SalesTest {
    private static final long PRODUCT_ID = 10L;
    private String currentClientId;
    private InMemoryProductCatalog productCatalog;

    @Before
    public void setup() {
        this.productCatalog = new InMemoryProductCatalog();
        this.thereIsProductWithId(PRODUCT_ID);
    }

    private void thereIsProductWithId(Long productId) {
        this.productCatalog.setAvailableProducts(Arrays.asList(new Product(productId, BigDecimal.valueOf(10.0))));
    }

    @Test
    public void iAmAbleToAddProductToBasket() {
        //Arrange
        SalesFacade salesFacade = getSalesFacade();
        //Act
        salesFacade.addToBasket(PRODUCT_ID);
        Basket basket = salesFacade.getCurrentBasket();
        //Assert //That
        assertThat(basket.productsCount()).isEqualTo(1);
    }

    @Test
    public void twoClientsHaveSeparatedBaskets() {
        //Arrange
        SalesFacade salesFacade = getSalesFacade();
        //Act
        iAmClientIdentifiedWith("client1");
        salesFacade.addToBasket(PRODUCT_ID);
        Basket basketOwnedByClient1 = salesFacade.getCurrentBasket();

        iAmClientIdentifiedWith("client2");
        salesFacade.addToBasket(PRODUCT_ID);
        Basket basketOwnedByClient2 = salesFacade.getCurrentBasket();
        // Assert
        assertThat(basketOwnedByClient1).isNotEqualTo(basketOwnedByClient2);
    }

    private void iAmClientIdentifiedWith(String clientId) {
        this.currentClientId = clientId;
    }

    private SalesFacade getSalesFacade() {
        return new SalesFacade(
                () -> currentClientId,
                new InMemoryBasketStorage(),
                this.productCatalog);
    }

}
