package pl.pirakaco.pp5.ebooks.crm;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
public class EbookController {

    @Autowired
    EbookRepository ebookRepository;

    @GetMapping("api/ebook/{id}")
    EbookData ebook(@PathVariable String id) {
        return ebookRepository.findById(id).orElseThrow(IllegalStateException::new);
    }

    @PostMapping("api/ebooks")
    String create(@RequestBody EbookData ebookData) {
        ebookData.setId(UUID.randomUUID().toString());
        ebookRepository.save(ebookData);
        return ebookData.getId();
    }

    @DeleteMapping("api/ebooks/{id}")
    void deleteEbook(@PathVariable String id) {
        ebookRepository.deleteById(id);
    }

    @PutMapping("api/ebooks/{id}")
    EbookData updateEbook(@RequestBody EbookData newEbook, @PathVariable String id) {
        return ebookRepository.findById(id)
                .map(ebook -> {
                    ebook.seteBookName(newEbook.geteBookName());
                    ebook.setAuthorFirstName(newEbook.getAuthorFirstName());
                    ebook.setAuthorLastName(newEbook.getAuthorLastName());
                    ebook.setDescription(newEbook.getDescription());
                    ebook.setFileSize(newEbook.getFileSize());
                    ebook.setReleaseDate(newEbook.getReleaseDate());
                    ebook.setFormat(newEbook.getFormat());
                    ebook.setISBN(newEbook.getISBN());
                    ebook.setPrice(newEbook.getPrice());
                    ebook.setPublishingHouse(newEbook.getPublishingHouse());
                    return ebookRepository.save(ebook);
                })
                .orElseGet(() -> {
                    newEbook.setId(id);
                    return ebookRepository.save(newEbook);
                });
    }

    @GetMapping("api/ebooks")
    Iterable<EbookData> loadAll() {
        return ebookRepository.findAll();
    }
}
