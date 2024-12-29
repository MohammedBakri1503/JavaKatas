package katas.exercises;

import org.junit.jupiter.api.Test;

import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class NginxLogsParserTest {

    @Test
    public void testValidLog() {
        String logEntry = "122.176.223.47 - - [05/Feb/2024:08:29:40 +0000] " +
                "\"GET /web-enabled/Enhanced-portal/bifurcated-forecast.js HTTP/1.1\" 200 1684 " +
                "\"-\" \"Opera/9.58 (X11; Linux i686; en-US) Presto/2.12.344 Version/13.00\"";

        Map<String, String> expected = Map.of(
                "client_ip", "122.176.223.47",
                "date", "05/Feb/2024:08:29:40 +0000",
                "http_method", "GET",
                "path", "/web-enabled/Enhanced-portal/bifurcated-forecast.js",
                "http_version", "1.1",
                "status", "200",
                "response_bytes", "1684",
                "user_agent", "Opera/9.58 (X11; Linux i686; en-US) Presto/2.12.344 Version/13.00"
        );

        Map<String, String> result = NginxLogsParser.parseLog(logEntry);
        assertEquals(expected, result, "Parsed log data does not match the expected result");
    }

    @Test
    public void testInvalidLog() {
        String invalidLogEntry = "Invalid log format";
        assertThrows(IllegalArgumentException.class, () -> NginxLogsParser.parseLog(invalidLogEntry),
                "Expected IllegalArgumentException for invalid log format");
    }

    @Test
    public void testPartialLog() {
        String partialLogEntry = "122.176.223.47 - - [05/Feb/2024:08:29:40 +0000] " +
                "\"GET /web-enabled/Enhanced-portal/bifurcated-forecast.js HTTP/1.1\" 200";
        assertThrows(IllegalArgumentException.class, () -> NginxLogsParser.parseLog(partialLogEntry),
                "Expected IllegalArgumentException for incomplete log format");
    }

    @Test
    public void testEmptyLog() {
        String emptyLogEntry = "";
        assertThrows(IllegalArgumentException.class, () -> NginxLogsParser.parseLog(emptyLogEntry),
                "Expected IllegalArgumentException for empty log entry");
    }
}
