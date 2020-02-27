package pl.pirakaco.pp5.ebooks.sales;

import pl.pirakaco.pp5.ebooks.sales.basket.Basket;
import pl.pirakaco.pp5.ebooks.sales.basket.BasketStorage;
import pl.pirakaco.pp5.ebooks.sales.exceptions.ProductCantBeAddedException;
import pl.pirakaco.pp5.ebooks.sales.products.Product;
import pl.pirakaco.pp5.ebooks.sales.products.ProductCatalog;

public class SalesFacade {
    private UserContext userContext;
    private BasketStorage basketStorage;
    private ProductCatalog productCatalog;

    public SalesFacade(UserContext userContext, BasketStorage basketStorage, ProductCatalog productCatalog) {
        this.userContext = userContext;
        this.basketStorage = basketStorage;
        this.productCatalog = productCatalog;
    }

    public void addToBasket(String id) {
        String clientId = userContext.getCurrentUserId();

        Basket basket = basketStorage.getForClient(clientId)
                .orElse(Basket.empty());
        Product product = productCatalog.load(id)
                .orElseThrow(ProductCantBeAddedException::new);
        basket.add(product);
        basketStorage.save(clientId, basket);
    }

    public Basket getCurrentBasket() {
        String clientId = userContext.getCurrentUserId();
        return basketStorage.getForClient(clientId)
                .orElse(Basket.empty());
    }
}
