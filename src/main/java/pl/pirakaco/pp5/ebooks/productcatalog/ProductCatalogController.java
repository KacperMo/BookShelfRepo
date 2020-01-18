package pl.pirakaco.pp5.ebooks.productcatalog;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class ProductCatalogController {

    @Autowired
    ProductCatalogFacade productCatalogFacade;

//    @GetMapping("api/ebook/{id}")
//    Product ebook(@PathVariable String id) {
//        return productCatalogRepository.findById(id).orElseThrow(IllegalStateException::new);
//    }
//
//    @PostMapping("api/ebooks")
//    String create(@RequestBody Product productCatalog) {
//        productCatalog.setId(UUID.randomUUID().toString());
//        productCatalogRepository.save(productCatalog);
//        return productCatalog.getId();
//    }
//
//    @DeleteMapping("api/ebooks/{id}")
//    void deleteEbook(@PathVariable String id) {
//        productCatalogRepository.deleteById(id);
//    }
//
//    @PutMapping("api/ebooks/{id}")
//    Product updateEbook(@RequestBody Product newEbook, @PathVariable String id) {
//        return productCatalogRepository.findById(id)
//                .map(ebook -> {
//                    ebook.seteBookName(newEbook.geteBookName());
//                    ebook.setAuthorFirstName(newEbook.getAuthorFirstName());
//                    ebook.setAuthorLastName(newEbook.getAuthorLastName());
//                    ebook.setDescription(newEbook.getDescription());
//                    ebook.setFileSize(newEbook.getFileSize());
//                    ebook.setReleaseDate(newEbook.getReleaseDate());
//                    ebook.setFormat(newEbook.getFormat());
//                    ebook.setISBN(newEbook.getISBN());
//                    ebook.setPrice(newEbook.getPrice());
//                    ebook.setPublishingHouse(newEbook.getPublishingHouse());
//                    return productCatalogRepository.save(ebook);
//                })
//                .orElseGet(() -> {
//                    newEbook.setId(id);
//                    return productCatalogRepository.save(newEbook);
//                });
//    }

    @GetMapping("/ebooks")
    List<Product> loadAll() {
        return productCatalogFacade.loadAll();
    }
}
