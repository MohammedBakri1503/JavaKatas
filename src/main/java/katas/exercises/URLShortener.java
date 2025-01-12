package katas.exercises;

import java.util.HashMap;
import java.util.Map;

public class URLShortener {
    /**
     * A URL Shortener is a service that converts a long URL into a shorter, more manageable URL.
     * Implement a simple URL shortener system with the following functionality:
     *
     *  - Convert a long URL into a short URL.
     *  - Retrieve the original long URL from a given short URL.
     *  - The system should handle the cases where multiple long URLs may share the same short URL, such as through hash collisions (you can assume no collisions for simplicity in this exercise).
     *  - The class should use a hash map to store the mapping between short and long URLs.
     *  - The short URL should be a base62 string (characters A-Z, a-z, 0-9).
     */

    private Map<String, String> urlMap;
    private Map<String, String> reverseMap;
    private static final String BASE_URL = "http://short.ly/";
    private static final String BASE62 = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
    private int counter;

    /**
     * Constructor to initialize the URL shortener system.
     */
    public URLShortener() {
        urlMap = new HashMap<>();
        reverseMap = new HashMap<>();
        counter = 1;
    }

    /**
     * Shortens the provided long URL.
     *
     * @param longUrl the long URL to shorten
     * @return the shortened URL
     */
    public String shorten(String longUrl) {
        if (reverseMap.containsKey(longUrl)) {
            return reverseMap.get(longUrl);
        }

        String shortUrl = BASE_URL + encode(counter);
        urlMap.put(shortUrl, longUrl);
        reverseMap.put(longUrl, shortUrl);
        counter++;
        return shortUrl;
    }

    /**
     * Retrieves the original long URL from the shortened URL.
     *
     * @param shortUrl the shortened URL
     * @return the original long URL
     */
    public String retrieve(String shortUrl) {
        return urlMap.get(shortUrl);
    }

    /**
     * Encodes a number into a base62 string.
     *
     * @param number the number to encode
     * @return the base62 encoded string
     */
    private String encode(int number) {
        StringBuilder encoded = new StringBuilder();
        while (number > 0) {
            encoded.append(BASE62.charAt(number % 62));
            number /= 62;
        }
        return encoded.reverse().toString();
    }

    public static void main(String[] args) {
        URLShortener shortener = new URLShortener();

        String longUrl = "https://www.example.com/some/really/long/url";
        String shortUrl = shortener.shorten(longUrl);

        System.out.println("Shortened URL: " + shortUrl);
        System.out.println("Original URL: " + shortener.retrieve(shortUrl));
    }
}
