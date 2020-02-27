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
        return productCatalogRepository.findAllPublished();
    }

    public Long create(Product product) {
        productCatalogRepository.save(product);
        return product.id;
    }

    public ProductData load(Long id) {
        return productCatalogRepository.findById(id)
                .map(Product::toData)
                .orElseThrow(NoSuchProductException::new);
    }

    public void deleteById(Long id) {
        productCatalogRepository.deleteById(id);
    }

    public Product modify(Long id, Product updatedProduct) {
        return productCatalogRepository.findById(id).map(eBook -> {
            eBook.setEBookTitle(updatedProduct.getEBookTitle());
            eBook.setAuthorFirstName(updatedProduct.getAuthorFirstName());
            eBook.setAuthorLastName(updatedProduct.getAuthorLastName());
            eBook.setEBookDescription(updatedProduct.getEBookDescription());
            eBook.setPrice(updatedProduct.getPrice());
            return productCatalogRepository.save(eBook);
        })
                .orElseGet(() -> {
                    updatedProduct.setId((id));
                    return productCatalogRepository.save(updatedProduct);
                });
    }
}
