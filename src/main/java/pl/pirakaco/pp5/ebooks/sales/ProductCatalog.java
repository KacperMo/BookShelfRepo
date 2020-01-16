package pl.pirakaco.pp5.ebooks.sales;

import java.util.Optional;

public interface ProductCatalog {
    Optional<Product> load(long productId);
}
