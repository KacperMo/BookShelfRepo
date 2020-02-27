package pl.pirakaco.pp5.ebooks.sales.payment;

import java.util.Map;

public interface HttpFormClient {
    String post(String url, Map<String, String> params);
}
