package pl.pirakaco.pp5.ebooks.productcatalog;

import pl.pirakaco.pp5.ebooks.productcatalog.dto.ProductData;
import pl.pirakaco.pp5.ebooks.productcatalog.exceptions.NoSuchProductException;

import java.util.List;

public class ProductCatalogFacade {
    ProductCatalogRepository productCatalogRepository;

    public ProductCatalogFacade (ProductCatalogRepository productCatalogRepository) {
        this.productCatalogRepository = productCatalogRepository;
    }
    public List<Product> loadAll() {
        return productCatalogRepository.findAll();
    }

    public String create(Product product) {
        productCatalogRepository.save(product);
        return product.id;
    }

    public ProductData load(String id) {
        return productCatalogRepository.findById(id)
                .map(Product::toData)
                .orElseThrow(NoSuchProductException::new);
    }
}
