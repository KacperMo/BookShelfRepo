package pl.pirakaco.pp5.ebooks.sales.payment;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class Md5Encoder {
    public String encode(String input) throws NoSuchAlgorithmException {
        MessageDigest messageDigest = MessageDigest.getInstance("MD5");
        messageDigest.update(input.getBytes(), 0, input.length());
        BigInteger i = new BigInteger(1, messageDigest.digest());
        return String.format("%1$032x", i);
    }
}
