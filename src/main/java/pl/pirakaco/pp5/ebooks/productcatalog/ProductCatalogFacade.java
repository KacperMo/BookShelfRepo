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

    public String create(Product product) {
        productCatalogRepository.save(product);
        return product.id;
    }

    public ProductData load(String id) {
        return productCatalogRepository.findById(id)
                .map(Product::toData)
                .orElseThrow(NoSuchProductException::new);
    }

    public void deleteById(String id) {
        productCatalogRepository.deleteById(id);
    }

    public Product modify(String id, Product updatedProduct) {
        return productCatalogRepository.findById(id).map(ebook -> {
            ebook.setEBookTitle(updatedProduct.getEBookTitle());
            ebook.setAuthorFirstName(updatedProduct.getAuthorFirstName());
            ebook.setAuthorLastName(updatedProduct.getAuthorLastName());
            ebook.setEBookDescription(updatedProduct.getEBookDescription());
            ebook.setPrice(updatedProduct.getPrice());
            return productCatalogRepository.save(ebook);
        })
                .orElseGet(() -> {
                    updatedProduct.setId(id);
                    return productCatalogRepository.save(updatedProduct);
                });
    }
}
