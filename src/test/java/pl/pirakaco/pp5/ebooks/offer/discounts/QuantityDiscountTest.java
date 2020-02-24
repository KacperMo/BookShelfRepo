package pl.pirakaco.pp5.ebooks.offer.discounts;

import org.junit.Assert;
import org.junit.Test;
import pl.pirakaco.pp5.ebooks.sales.offer.Discount;
import pl.pirakaco.pp5.ebooks.sales.offer.Offer;
import pl.pirakaco.pp5.ebooks.sales.offer.OfferItem;
import pl.pirakaco.pp5.ebooks.sales.offer.discounts.QuantityDiscount;

import java.util.UUID;

public class QuantityDiscountTest {
    @Test
    public void itAppliesDiscountBasedOnQuantity() {
        QuantityDiscount discount = new QuantityDiscount(5, 0.20);
        OfferItem offerItem = new OfferItem(UUID.randomUUID().toString(), 5, 50.00);

        Discount discount1 = discount.calculateDiscount(offerItem);
        offerItem.apply(discount1);

        Assert.assertTrue(40.00 == offerItem.getTotalCost());
    }
}
