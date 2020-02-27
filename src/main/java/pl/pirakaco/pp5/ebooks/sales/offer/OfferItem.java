package pl.pirakaco.pp5.ebooks.sales.offer;

import lombok.Getter;

@Getter
public class OfferItem {
    String id;
    Integer quantity;
    Double totalCost;
    Discount discount;

    public OfferItem(String id, Integer quantity, Double totalCost) {
        this.id = id;
        this.quantity = quantity;
        this.totalCost = totalCost;
        this.discount = Discount.noDiscount();
    }

    public Double getTotalCost() {
        return (totalCost - discount.getValue()) <= 0 ? 0.00 : (totalCost - discount.getValue());
    }

    public void apply(Discount discount) {
        this.discount = discount;
    }
}
