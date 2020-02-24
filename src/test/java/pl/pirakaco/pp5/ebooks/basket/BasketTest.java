package pl.pirakaco.pp5.ebooks.basket;

import org.junit.Assert;
import org.junit.Test;
import pl.pirakaco.pp5.ebooks.sales.basket.Basket;
import pl.pirakaco.pp5.ebooks.sales.basket.BasketItem;
import pl.pirakaco.pp5.ebooks.sales.products.Product;
import pl.pirakaco.pp5.ebooks.support.modelling.Identifier;

import java.util.List;

public class BasketTest {
    @Test
    public void iAmAllowedToAddProductToBasket() {
        Product product1 = new Product(Identifier.byString("book1"), 2);
        Basket basket = new Basket();

        basket.add(product1);
        Assert.assertFalse(basket.isEmpty());
    }

    @Test
    public void isNewBasketEmpty() {
        Basket basket = new Basket();
        Assert.assertTrue(basket.isEmpty());
    }

    @Test
    public void iAmAllowedToAddMultipleProductsToBasket() {
        Product product1 = new Product(Identifier.byString("book1"), 3);
        Product product2 = new Product(Identifier.byString("Boook2"), 4);

        Basket basket = new Basket();

        basket.add(product1);
        basket.add(product2);

        Assert.assertEquals(2, basket.productsCount());
    }

    @Test
    public void iAmAllowedToAddMultipleSameTypeProducts() {
        Product product = new Product(Identifier.byString("boo1"), 4);
        Product product1 = new Product(Identifier.byString("ksiazk2"), 4);

        Basket basket = new Basket();

        basket.add(product);
        basket.add(product);
        basket.add(product);
        basket.add(product);
        basket.add(product1);

        Assert.assertEquals(2, basket.productsCount());
    }

    @Test
    public void productQuantityIsIncreasedForAlreadyAddedProduct() {
        Product product = new Product(Identifier.byString("boo1"), 4);
        Product product1 = new Product(Identifier.byString("ksiazk2"), 4);

        Basket basket = new Basket();

        basket.add(product);
        basket.add(product);
        basket.add(product);
        basket.add(product);
        basket.add(product1);

        Assert.assertEquals(2, basket.productsCount());
        Assert.assertEquals(BasketItem.class, basket.getReservedItems().get(0).getClass());

        thereIsFollowingQuantityOfReservedProduct(4, product, basket.getReservedItems());
    }

    private void thereIsFollowingQuantityOfReservedProduct(Integer quantity, Product product, List<BasketItem> reservedItems) {
        reservedItems.stream()
                .filter(item -> item.getId().equals(product.getProductId()))
                .forEach(item -> Assert.assertEquals(quantity, item.getQuantity()));
    }

    @Test
    public void basketCanBeCleared() {
        Product product = new Product(Identifier.byString("boo1"), 4);

        Basket basket = new Basket();

        basket.add(product);

        basket.clear();

        Assert.assertTrue(basket.isEmpty());
    }
}
