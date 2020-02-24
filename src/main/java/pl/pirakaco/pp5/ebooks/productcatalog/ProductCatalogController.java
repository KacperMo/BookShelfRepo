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

    @GetMapping("/ebook/{id}")
    ProductData ebook(@PathVariable String id) {
        return productCatalogFacade.load(id);
    }

    //create new ebook and return its id
    @PostMapping("/ebooks")
    String createNewEBook(@RequestBody Product newProduct) {
        return productCatalogFacade.create(newProduct);
    }

    @DeleteMapping("/ebooks/{id}")
    void deleteEbook(@PathVariable String id) {
        productCatalogFacade.deleteById(id);
    }

    @PutMapping("ebooks/{id}")
    ProductData updateEBook(@RequestBody Product newEBook, @PathVariable String id) {
        productCatalogFacade.modify(id, newEBook);
        return productCatalogFacade.load(id);
    }


}
