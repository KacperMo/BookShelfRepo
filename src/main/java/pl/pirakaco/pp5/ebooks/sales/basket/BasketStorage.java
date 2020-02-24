package pl.pirakaco.pp5.ebooks.sales.basket;

import pl.pirakaco.pp5.ebooks.sales.basket.Basket;

import java.util.Optional;

public interface BasketStorage {
    Optional <Basket> getForClient(String clientId);
    void save(String clientId, Basket basket);
}
