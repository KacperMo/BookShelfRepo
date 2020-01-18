package pl.pirakaco.pp5.ebooks.productcatalog;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductCatalogRepository extends JpaRepository<Product, String> {
}
