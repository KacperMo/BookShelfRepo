package pl.pirakaco.pp5.ebooks.sales;

import pl.pirakaco.pp5.ebooks.sales.exceptions.ProductCantBeAddedException;

public class SalesFacade {
    private UserContext userContext;
    private BasketStorage basketStorage;
    private ProductCatalog productCatalog;

    public SalesFacade(UserContext userContext, BasketStorage basketStorage, ProductCatalog productCatalog) {
        this.userContext = userContext;
        this.basketStorage = basketStorage;
        this.productCatalog = productCatalog;
    }

    public void addToBasket(Long id) {
        String clientId = userContext.getCurrentUserId();

        Basket basket = basketStorage.getForClient(clientId)
                .orElse(Basket.empty());
        Product product = productCatalog.load(id)
                .orElseThrow(ProductCantBeAddedException::new);
        basket.add(product);
        basketStorage.save(basket);
    }

    public Basket getCurrentBasket() {
        String clientId = userContext.getCurrentUserId();
        return basketStorage.getForClient(clientId)
                .orElse(Basket.empty());
    }
}
