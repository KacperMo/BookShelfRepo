package pl.pirakaco.pp5.ebooks.sales.offer.discounts;

import lombok.AllArgsConstructor;
import pl.pirakaco.pp5.ebooks.sales.offer.Discount;
import pl.pirakaco.pp5.ebooks.sales.offer.DiscountPolicy;
import pl.pirakaco.pp5.ebooks.sales.offer.OfferItem;

@AllArgsConstructor
public class QuantityDiscount implements DiscountPolicy {
    private Integer itemCount;
    private Double discountValue;


    @Override
    public Discount calculateDiscount(OfferItem item) {
        if (item.getQuantity() >= itemCount) {
            return new Discount("Item count", (item.getTotalCost() * discountValue));
        }
        return Discount.noDiscount();
    }
}
