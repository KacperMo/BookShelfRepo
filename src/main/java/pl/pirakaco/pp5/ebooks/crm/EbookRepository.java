package pl.pirakaco.pp5.ebooks.crm;

import org.springframework.data.repository.CrudRepository;

public interface EbookRepository extends CrudRepository<EbookData, String> {
}
