package pl.pirakaco.pp5.ebooks;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.ApplicationStartedEvent;
import org.springframework.context.event.EventListener;
import pl.pirakaco.pp5.ebooks.productcatalog.Product;
import pl.pirakaco.pp5.ebooks.productcatalog.ProductCatalogFacade;

import java.math.BigDecimal;

@SpringBootApplication
public class App {
    public static void main(String[] args) {
        SpringApplication.run(App.class, args);
    }

    @Autowired
    ProductCatalogFacade productCatalogFacade;

    @EventListener(value = ApplicationStartedEvent.class)
    public void putEBooksOnStart() {
        productCatalogFacade.create(Product.builder()
                .eBookTitle("The Tower of Swallows")
                .published(true)
                .authorFirstName("Andrzej")
                .authorLastName("Sapkowski")
                .price(BigDecimal.valueOf(50))
                .cover("https://www.bookoff.pl/pol_pl_The-Witcher-The-Tower-of-the-Swallow-101495_1.jpg")
                .eBookDescription("The world has fallen into war. Ciri, the child of prophecy, has vanished. Hunted by friends and foes alike, she has taken on the guise of a petty bandit and lives free for the first time in her life.")
                .build()
        );
        productCatalogFacade.create(Product.builder()
                .eBookTitle("Management 3.0")
                .published(true)
                .authorFirstName("Appelo")
                .authorLastName("Jurgen")
                .price(BigDecimal.valueOf(30))
                .cover("https://ecsmedia.pl/c/management-3-0-b-iext44120825.jpg")
                .eBookDescription("Pragmatic Insights for Successfully Managing Your Unique Agile Team or Organization")
                .build()
        );
    }
}