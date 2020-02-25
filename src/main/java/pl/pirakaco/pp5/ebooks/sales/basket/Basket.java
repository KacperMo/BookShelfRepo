package pl.pirakaco.pp5.ebooks.sales.basket;

import pl.pirakaco.pp5.ebooks.sales.products.Product;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

public class Basket {
    private final HashMap<Product, Integer> productQuantities;
    public static Basket empty() {
        return new Basket();
    }

    public Basket() {
        this.productQuantities = new HashMap<>();
    }
    public int productsCount() {
        return productQuantities.size();
    }

    public List<BasketItem> getReservedItems() {
        ArrayList<BasketItem> items = new ArrayList<>(productQuantities.size());
        productQuantities.forEach((product, quantity) -> items.add(new BasketItem(String.valueOf(product.getProductId()), quantity, product.getPrice())));
        return Collections.unmodifiableList(items);
    }

    public void add(Product product) {
        if (!isInBasket(product)) {
            putToBasket(product);
        } else {
            increaseQuantity(product);
        }
    }

    private void increaseQuantity(Product product) {
        productQuantities.put(product, productQuantities.get(product) + 1);
    }

    private void putToBasket(Product product) {
        productQuantities.put(product, 1);
    }


    private boolean isInBasket(Product product) {
        return productQuantities.containsKey(product);
    }

    public void clear() {
        this.productQuantities.clear();
    }

    public boolean isEmpty() {
        return productQuantities.isEmpty();
    }
}
