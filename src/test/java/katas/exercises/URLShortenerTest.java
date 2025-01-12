package katas.exercises;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class URLShortenerTest {

    @Test
    void testShortenAndRetrieve() {
        URLShortener shortener = new URLShortener();

        String longUrl = "https://www.example.com/some/really/long/url";
        String shortUrl = shortener.shorten(longUrl);

        assertNotNull(shortUrl, "Shortened URL should not be null");
        assertTrue(shortUrl.startsWith("http://short.ly/"), "Shortened URL should start with the base URL");

        String retrievedUrl = shortener.retrieve(shortUrl);
        assertEquals(longUrl, retrievedUrl, "Retrieved URL should match the original long URL");
    }

    @Test
    void testShortenSameURL() {
        URLShortener shortener = new URLShortener();

        String longUrl = "https://www.example.com/some/really/long/url";
        String shortUrl1 = shortener.shorten(longUrl);
        String shortUrl2 = shortener.shorten(longUrl);

        assertEquals(shortUrl1, shortUrl2, "Shortening the same URL should return the same shortened URL");
    }

    @Test
    void testRetrieveNonExistentShortURL() {
        URLShortener shortener = new URLShortener();

        String retrievedUrl = shortener.retrieve("http://short.ly/NonExistent");
        assertNull(retrievedUrl, "Retrieving a non-existent short URL should return null");
    }

    @Test
    void testShortenMultipleURLs() {
        URLShortener shortener = new URLShortener();

        String longUrl1 = "https://www.example.com/1";
        String longUrl2 = "https://www.example.com/2";
        String longUrl3 = "https://www.example.com/3";

        String shortUrl1 = shortener.shorten(longUrl1);
        String shortUrl2 = shortener.shorten(longUrl2);
        String shortUrl3 = shortener.shorten(longUrl3);

        assertNotEquals(shortUrl1, shortUrl2, "Different URLs should have different shortened URLs");
        assertNotEquals(shortUrl2, shortUrl3, "Different URLs should have different shortened URLs");

        assertEquals(longUrl1, shortener.retrieve(shortUrl1), "Retrieved URL should match the original URL for shortUrl1");
        assertEquals(longUrl2, shortener.retrieve(shortUrl2), "Retrieved URL should match the original URL for shortUrl2");
        assertEquals(longUrl3, shortener.retrieve(shortUrl3), "Retrieved URL should match the original URL for shortUrl3");
    }

    @Test
    void testBase62Encoding() {
        URLShortener shortener = new URLShortener();

        // Private method testing via reflection (if allowed)
        String encoded = shortener.shorten("https://example.com/test");

        assertTrue(encoded.matches("http://short.ly/[a-zA-Z0-9]+"), "Shortened URL should use Base62 encoding");
    }
}
