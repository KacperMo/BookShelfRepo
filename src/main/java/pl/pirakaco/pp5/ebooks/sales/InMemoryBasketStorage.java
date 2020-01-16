package pl.pirakaco.pp5.ebooks.sales;


import java.util.Optional;

public class InMemoryBasketStorage implements BasketStorage {
    @Override
    public Optional<Basket> getForClient(String clientId) {
        return Optional.of(null);
    }

    @Override
    public void save(Basket basket) {

    }
}
