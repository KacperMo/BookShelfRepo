package pl.pirakaco.pp5.ebooks.sales.offer;

import lombok.Getter;

@Getter
public class Discount {
    private String cause;
    private Double value;

    public Discount(String cause, Double value) {
        this.cause = cause;
        this.value = value;
    }

    public static Discount noDiscount() {
        return new Discount("No discount", 0.0);
    }
}
