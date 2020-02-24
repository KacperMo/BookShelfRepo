package pl.pirakaco.pp5.ebooks.offer;

import org.junit.Assert;
import org.junit.Test;
import pl.pirakaco.pp5.ebooks.sales.offer.Discount;
import pl.pirakaco.pp5.ebooks.sales.offer.Offer;
import pl.pirakaco.pp5.ebooks.sales.offer.OfferItem;
import pl.pirakaco.pp5.ebooks.support.modelling.Identifier;

import java.util.ArrayList;
import java.util.List;

public class OfferTest {
    @Test
    public void itCalculatesTotalOfItems() {
        List<OfferItem> items = new ArrayList<>();
        items.add(new OfferItem(Identifier.byString("p1"), 2, 10.00));
        items.add(new OfferItem(Identifier.byString("p2"), 1, 10.00));

        Offer offer = new Offer(items);

        Assert.assertTrue(20.00 == offer.getTotal());
    }

    @Test
    public void itConsidersDiscountsWhenCalculatesTotalCost() {
        List<OfferItem> items = new ArrayList<>();
        OfferItem item = new OfferItem(Identifier.byString("p1"), 2, 10.00);
        item.apply(new Discount("static reduce", 10.00));
        items.add(item);
        items.add(new OfferItem(Identifier.byString("p2"), 1, 10.00));
        Offer offer = new Offer(items);

        Assert.assertTrue(10.00 == offer.getTotal());
    }
}
