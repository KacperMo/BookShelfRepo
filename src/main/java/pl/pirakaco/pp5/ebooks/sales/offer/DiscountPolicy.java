package pl.pirakaco.pp5.ebooks.sales.offer;

public interface DiscountPolicy {
    Discount calculateDiscount(OfferItem item);
}
