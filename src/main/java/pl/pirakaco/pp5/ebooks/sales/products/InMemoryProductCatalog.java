package pl.pirakaco.pp5.ebooks.sales.products;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class InMemoryProductCatalog implements ProductCatalog {
    private List<Product> availableProducts = new ArrayList<>();

    @Override
    public Optional<Product> load(String productId) {
        return availableProducts.stream()
                .filter(p -> p.getProductId().equals(productId))
                .findFirst();
    }

    public void setAvailableProducts(List<Product> products) {
        this.availableProducts = products;
    }
}
