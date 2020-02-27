package pl.pirakaco.pp5.ebooks.offer;

import org.junit.Assert;
import org.junit.Test;
import pl.pirakaco.pp5.ebooks.sales.offer.Discount;
import pl.pirakaco.pp5.ebooks.sales.offer.OfferItem;
import pl.pirakaco.pp5.ebooks.support.modelling.Identifier;

public class OfferItemTest {
    @Test
    public void itAllowsToApplyDiscountForItem() {
        OfferItem item = new OfferItem(Identifier.byString("p1"), 4, 10.00);
        item.apply(new Discount("static reduce", 5.00));

        Assert.assertTrue("Should match reduced price",item.getTotalCost() == 5.00);
    }

    @Test
    public void itReducesPriceToMax0() {
        OfferItem item = new OfferItem(Identifier.byString("p1"), 4, 10.00);
        item.apply(new Discount("static reduce", 100.00));

        Assert.assertTrue("Should match reduced price", item.getTotalCost() == 0);
    }
}
