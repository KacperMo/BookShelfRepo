package pl.pirakaco.pp5.ebooks.sales.payment;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class P24Properties {
    public static final String SANDBOX_URL = "https://sandbox.przelewy24.pl/trnDirect";
    public static final String REQUEST_URL = "https://sandbox.przelewy24.pl/trnRequest";
    String merchantId;
    String crcCode;

    public static P24Properties of(String merchantId, String crcCode) {
        return new P24Properties(merchantId, crcCode);
    }

    public String getSandboxUrl() {
        return SANDBOX_URL;
    }

    public String getRequestUrl() {
        return REQUEST_URL;
    }
}
