package pl.pirakaco.pp5.ebooks.sales.offer;

import lombok.Getter;

import java.util.List;

@Getter
public class Offer {
    private List<OfferItem> itemList;

    public Offer(List<OfferItem> itemList) {
        this.itemList = itemList;
    }

    public Double getTotal() {
        return itemList.stream()
                .map(OfferItem::getTotalCost)
                .reduce(Double::sum)
                .orElse(0.0);
    }
}
