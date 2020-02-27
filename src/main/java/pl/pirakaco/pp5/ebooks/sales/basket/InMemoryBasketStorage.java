package pl.pirakaco.pp5.ebooks.sales.basket;


import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;

public class InMemoryBasketStorage implements BasketStorage {
    private final ConcurrentHashMap<String, Basket> baskets;

    public InMemoryBasketStorage() {
        this.baskets = new ConcurrentHashMap<>();
    }

    @Override
    public Optional<Basket> getForClient(String clientId) {
        return Optional.ofNullable(baskets.get(clientId));
    }

    @Override
    public void save(String clientId, Basket basket) {
        baskets.put(clientId, basket);
    }
}
