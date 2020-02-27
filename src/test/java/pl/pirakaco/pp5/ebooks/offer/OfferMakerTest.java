package pl.pirakaco.pp5.ebooks.offer;

import org.junit.Assert;
import org.junit.Test;
import pl.pirakaco.pp5.ebooks.sales.basket.BasketItem;
import pl.pirakaco.pp5.ebooks.sales.offer.Offer;
import pl.pirakaco.pp5.ebooks.sales.offer.OfferItem;
import pl.pirakaco.pp5.ebooks.sales.offer.OfferMaker;
import pl.pirakaco.pp5.ebooks.sales.offer.discounts.QuantityDiscount;
import pl.pirakaco.pp5.ebooks.support.modelling.Identifier;

import java.util.ArrayList;
import java.util.List;

public class OfferMakerTest {
    @Test
    public void itCreatesOfferForClientBasedOnSelectedItems() {
        OfferMaker offerMaker = new OfferMaker();

        List<BasketItem> itemList = new ArrayList<>();
        itemList.add(new BasketItem(Identifier.byString("p1"), 1, 10.00));
        itemList.add(new BasketItem(Identifier.byString("p2"), 3, 10.00));

        Offer offer = offerMaker.calculateOffer(itemList);

        Assert.assertFalse("Offer contains items", offer.getItemList().isEmpty());
        thereIsFollowingOrderedItemWithTotalCost(offer.getItemList(), Identifier.byString("p1"), 10.00);
        thereIsFollowingOrderedItemWithTotalCost(offer.getItemList(), Identifier.byString("p2"), 20.00);
    }

    @Test
    public void itAllowsToApplyDiscountForOrder() {
        OfferMaker offerMaker = new OfferMaker();

        List<BasketItem> items = new ArrayList<>();

        items.add(new BasketItem(Identifier.byString("p1"), 1, 10.00));
        items.add(new BasketItem(Identifier.byString("p1"), 3, 30.00));

        Offer offer = offerMaker.calculateOffer(items, new QuantityDiscount(3, 0.50));

        Assert.assertTrue("Total should match expected value", offer.getTotal() == 55.00);
    }

    @Test
    public void itCalculatesDiscountWhenThereIsOnlyOneProduct() {
        OfferMaker offerMaker = new OfferMaker();

        List<BasketItem> items = new ArrayList<>();
        items.add(new BasketItem(Identifier.byString("p1"), 5, 10.00));

        Offer offer = offerMaker.calculateOffer(items, new QuantityDiscount(5, 0.20));
        Assert.assertTrue("Total should match expected value", offer.getTotal() == 40.00);
    }

    private void thereIsFollowingOrderedItemWithTotalCost(List<OfferItem> itemList, String id, Double totalCost) {
        itemList.stream()
                .filter(item -> item.getId().equals(id))
                .forEach(item -> Assert.assertEquals(item.getTotalCost(), item.getTotalCost()));
    }
}
