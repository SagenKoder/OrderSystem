package app.sagen.ordersystem.backend.util;

import java.util.Random;

public class StringUtils {

    public static String getRandomString(int length) {
        String charset = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890";
        return getString(length, charset);
    }

    public static String getRandomNumberString(int length) {
        String charset = "1234567890";
        return getString(length, charset);
    }

    private static String getString(int length, String charset) {
        StringBuilder builder = new StringBuilder();
        Random rnd = new Random();
        while (builder.length() < length) {
            int index = (int) (rnd.nextFloat() * charset.length());
            builder.append(charset.charAt(index));
        }
        return builder.toString();
    }

}
