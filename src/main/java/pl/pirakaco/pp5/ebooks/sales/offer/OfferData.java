package pl.pirakaco.pp5.ebooks.sales.offer;

import lombok.Getter;

@Getter
public class OfferData {
    private Double total;
    private Integer itemsCount;
    private String currency = "PLN";

    public OfferData(Double total, Integer itemsCount) {
        this.total = total;
        this.itemsCount = itemsCount;
    }
}
