package pl.pirakaco.pp5.ebooks.sales;

import java.util.Optional;

public interface BasketStorage {
    Optional <Basket> getForClient(String clientId);
    void save(Basket basket);
}
