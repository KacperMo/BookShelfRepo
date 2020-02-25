package pl.pirakaco.pp5.ebooks.sales.payment;

import java.security.NoSuchAlgorithmException;
import java.util.HashMap;
import java.util.Map;

public class P24Gateway {
    public static final String CURRENCY = "PLN";
    private P24Properties p24Properties;
    private HttpFormClient http;
    private Md5Encoder encoder;

    public P24Gateway(P24Properties properties, HttpFormClient client, Md5Encoder encoder) {
        this.p24Properties = properties;
        this.http = client;
        this.encoder = encoder;
    }

    public String registerPayment(PaymentRequest request) {
        Map<String, String> paramsToSend = new HashMap<>();
        paramsToSend.put("p24_merchant_id", p24Properties.merchantId);
        paramsToSend.put("p24_pos_id", p24Properties.merchantId);
        paramsToSend.put("p24_session_id", request.transactionId);
        paramsToSend.put("p24_api_version", "3.2");
        paramsToSend.put("p24_sign", generateMd5Checksum(request));
        paramsToSend.put("p24_amount", request.moneyAs100Unit().toString());
        paramsToSend.put("p24_description", "payment for ebooks");
        paramsToSend.put("p24_country", "PL");
        return sendHttpRequest(p24Properties.getSandboxUrl(), paramsToSend);
    }

    private String sendHttpRequest(String sandboxUrl, Map<String, String> paramsToSend) {
        return this.http.post(sandboxUrl, paramsToSend);
    }

    private String generateMd5Checksum(PaymentRequest request) {
        try {
            return encoder.encode(String.format(
                    "%s|%s|%s|%s|%s",
                    request.transactionId,
                    p24Properties.merchantId,
                    request.moneyAs100Unit(),
                    CURRENCY,
                    p24Properties.crcCode
            ));
        } catch (NoSuchAlgorithmException e) {
            return "";
        }
    }

    public String getPaymentUrl(String paymentToken) {
        return p24Properties.getRequestUrl() + "/" + paymentToken;
    }
}
