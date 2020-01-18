package pl.pirakaco.pp5.ebooks.productcatalog;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ProductCatalogConfiguration {
    @Bean
    ProductCatalogFacade productCatalogFacade(ProductCatalogRepository productCatalogRepository) {
        return new ProductCatalogFacade(productCatalogRepository);
    }
}
