package pl.pirakaco.pp5.ebooks.sales.products;

import java.util.Optional;

public interface ProductCatalog {
    Optional<Product> load(String productId);
}
