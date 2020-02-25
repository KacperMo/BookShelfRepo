package pl.pirakaco.pp5.ebooks.productcatalog;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pl.pirakaco.pp5.ebooks.productcatalog.dto.ProductData;

import java.util.*;

@RestController
@RequestMapping("/api")
public class ProductCatalogController {

    @Autowired
    private ProductCatalogFacade productCatalogFacade;

    @GetMapping("/products")
    List<Product> loadAll() {
        return productCatalogFacade.loadAll();
    }

    @GetMapping("/products/{id}")
    ProductData ebook(@PathVariable Long id) {
        return productCatalogFacade.load(id);
    }

    //create new ebook and return its id
    @PostMapping("/products")
    Long createNewEBook(@RequestBody Product newProduct) {
        return productCatalogFacade.create(newProduct);
    }

    @DeleteMapping("/products/{id}")
    void deleteEbook(@PathVariable Long id) {
        productCatalogFacade.deleteById(id);
    }

    @PutMapping("/products/{id}")
    ProductData updateEBook(@RequestBody Product newEBook, @PathVariable Long id) {
        productCatalogFacade.modify(id, newEBook);
        return productCatalogFacade.load(id);
    }


}
