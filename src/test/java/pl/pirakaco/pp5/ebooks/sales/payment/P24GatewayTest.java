package pl.pirakaco.pp5.ebooks.sales.payment;

import org.junit.Assert;
import org.junit.Test;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

public class P24GatewayTest {
    private static final String EXPECTED_MD5_CODE = "ee89f7848d91959e8f46803ea9476778";
    public static final String MERCHANT_ID = "123456";
    public static final String CRC_CODE = "crc_123456789";

    static class HttpClient implements HttpFormClient {
        public Map<String, String> lastRequest;

        @Override
        public String post(String url, Map<String, String> params) {
            lastRequest = params;
            return "OK";
        }
    }

    @Test
    public void itGeneratesRedirectionURLBasedOnToken() {
        HttpClient httpClient = new HttpClient();
        P24Gateway p24Gateway = thereIsP24Gateway(httpClient);

        String paymentToken = "my_token";
        String redirectURL = p24Gateway.getPaymentUrl(paymentToken);

        assertThat(redirectURL).isEqualTo("https://sandbox.przelewy24.pl/trnRequest/my_token");
    }

    @Test
    public void itAllowsToRegisterPayment() {
        PaymentRequest paymentRequest = thereIsExamplePaymentRequest();
        HttpClient httpClient = new HttpClient();
        P24Gateway p24Gateway = thereIsP24Gateway(httpClient);

        String paymentToken = p24Gateway.registerPayment(paymentRequest);

        assertThat(httpClient.lastRequest).containsKeys("p24_merchant_id", "p24_pos_id", "p24_sign", "p24_api_version");
        assertThat(httpClient.lastRequest.get("p24_sign")).isEqualTo(EXPECTED_MD5_CODE);
        assertThat(httpClient.lastRequest).isEqualToComparingFieldByField(expectedRegisterParams());
    }

    private Map<String, String> expectedRegisterParams() {
        return new HashMap<>();
    }

    private PaymentRequest thereIsExamplePaymentRequest() {
        return PaymentRequest.builder()
                .email("john.doe@example.dev")
                .amount(BigDecimal.valueOf(25.50))
                .transactionId("order_1")
                .build();
    }

    private P24Gateway thereIsP24Gateway(HttpClient httpClient) {
        return new P24Gateway(P24Properties.of(MERCHANT_ID, CRC_CODE),
                httpClient, new Md5Encoder());
    }
}
