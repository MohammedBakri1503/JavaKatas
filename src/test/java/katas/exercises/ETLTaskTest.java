package katas.exercises;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.*;
import java.sql.*;
import java.time.LocalDate;

class ETLTaskTest {
    private static Connection sourceConn;
    private static Connection targetConn;

    @BeforeAll
    static void setupDatabases() throws SQLException {
        sourceConn = DriverManager.getConnection("jdbc:sqlite::memory:");
        targetConn = DriverManager.getConnection("jdbc:sqlite::memory:");

        try (Statement stmt = sourceConn.createStatement()) {
            stmt.execute("CREATE TABLE users (" +
                    "id INTEGER PRIMARY KEY, " +
                    "name TEXT NOT NULL, " +
                    "email TEXT NOT NULL, " +
                    "age INTEGER, " +
                    "registration_date TEXT NOT NULL)");
        }
    }

    @BeforeEach
    void clearData() throws SQLException {
        try (Statement stmt = sourceConn.createStatement()) {
            stmt.execute("DELETE FROM users");
        }
        try (Statement stmt = targetConn.createStatement()) {
            stmt.execute("DROP TABLE IF EXISTS transformed_users");
        }
    }



    @Test
    void testAgeGroupDetermination() {
        assertEquals("Under 30", invokeDetermineAgeGroup(25));
        assertEquals("30-60", invokeDetermineAgeGroup(45));
        assertEquals("60+", invokeDetermineAgeGroup(75));
    }

    @Test
    void testCalculateYearsRegistered() {
        assertEquals(5, invokeCalculateYearsRegistered(LocalDate.now().minusYears(5).toString()));
        assertEquals(10, invokeCalculateYearsRegistered(LocalDate.now().minusYears(10).toString()));
        assertEquals(0, invokeCalculateYearsRegistered(LocalDate.now().toString())); // Registered today
    }

    private String invokeDetermineAgeGroup(int age) {
        try {
            var method = ETLTask.class.getDeclaredMethod("determineAgeGroup", int.class);
            method.setAccessible(true);
            return (String) method.invoke(null, age);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    private int invokeCalculateYearsRegistered(String date) {
        try {
            var method = ETLTask.class.getDeclaredMethod("calculateYearsRegistered", String.class);
            method.setAccessible(true);
            return (int) method.invoke(null, date);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
