package utils;

import java.util.Base64;

/**
 * Helps to decode the base64 encoded string.
 */
public final class DecodeUtils {
    /**
     * Private constructor to avoid external instantiation
     */
    private DecodeUtils() {
    }

    /**
     * Accepts and base64 string,decode and return to the caller
     */
    public static String getDecodedString(String encodedString) {
        return new String(Base64.getDecoder().decode(encodedString.getBytes()));
    }

}
