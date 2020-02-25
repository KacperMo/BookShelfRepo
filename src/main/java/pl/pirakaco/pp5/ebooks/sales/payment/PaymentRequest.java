package pl.pirakaco.pp5.ebooks.sales.payment;

import lombok.*;

import java.math.BigDecimal;
import java.math.BigInteger;

@AllArgsConstructor
@Builder
@Data
@NoArgsConstructor
public class PaymentRequest {
    String email;
    BigDecimal amount;
    String transactionId;

    public BigInteger moneyAs100Unit() {
        return amount.multiply(BigDecimal.valueOf(100)).toBigInteger();
    }
}
