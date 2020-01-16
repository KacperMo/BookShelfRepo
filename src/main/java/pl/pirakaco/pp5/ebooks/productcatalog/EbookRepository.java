package pl.pirakaco.pp5.ebooks.productcatalog;

import org.springframework.data.repository.CrudRepository;

public interface EbookRepository extends CrudRepository<EbookData, String> {
}
