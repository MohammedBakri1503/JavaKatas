package katas.exercises;

import java.sql.*;
import java.time.LocalDate;
import java.time.Period;

public class ETLTask {

    /**
     * Performs the ETL operation from source.db to target.db.
     *
     * @param sourceDbPath the path to the source SQLite database
     * @param targetDbPath the path to the target SQLite database
     * @throws SQLException if an error occurs during database access
     */
    public static void performETL(String sourceDbPath, String targetDbPath) throws SQLException {
        try (Connection sourceConn = DriverManager.getConnection("jdbc:sqlite:" + sourceDbPath);
             Connection targetConn = DriverManager.getConnection("jdbc:sqlite:" + targetDbPath);
             Statement sourceStmt = sourceConn.createStatement()) {

            try (Statement targetStmt = targetConn.createStatement()) {
                targetStmt.execute("CREATE TABLE IF NOT EXISTS transformed_users (" +
                        "user_id INTEGER PRIMARY KEY, " +
                        "full_name TEXT NOT NULL, " +
                        "email TEXT NOT NULL, " +
                        "age_group TEXT, " +
                        "years_registered INTEGER)");
            }

            // Extract data from source database
            ResultSet rs = sourceStmt.executeQuery("SELECT * FROM users");

            // Prepare insert statement for transformed data
            String insertSQL = "INSERT INTO transformed_users (user_id, full_name, email, age_group, years_registered) " +
                    "VALUES (?, ?, ?, ?, ?)";
            try (PreparedStatement insertStmt = targetConn.prepareStatement(insertSQL)) {

                // Iterate over each user in the source database
                while (rs.next()) {
                    int userId = rs.getInt("id");
                    String fullName = rs.getString("name");
                    String email = rs.getString("email");
                    int age = rs.getInt("age");
                    String registrationDate = rs.getString("registration_date");

                    // Transform the data
                    String ageGroup = determineAgeGroup(age);
                    int yearsRegistered = calculateYearsRegistered(registrationDate);

                    // Insert transformed data into target database
                    insertStmt.setInt(1, userId);
                    insertStmt.setString(2, fullName);
                    insertStmt.setString(3, email);
                    insertStmt.setString(4, ageGroup);
                    insertStmt.setInt(5, yearsRegistered);

                    insertStmt.executeUpdate();
                }
            }
        }
    }

    /**
     * Determines the age group based on the user's age.
     *
     * @param age the age of the user
     * @return the age group as a String
     */
    private static String determineAgeGroup(int age) {
        if (age < 30) {
            return "Under 30";
        } else if (age >= 30 && age <= 60) {
            return "30-60";
        } else {
            return "60+";
        }
    }

    /**
     * Calculates the number of years since the registration date.
     *
     * @param registrationDate the registration date as a String in the format "yyyy-MM-dd"
     * @return the number of years registered
     */
    private static int calculateYearsRegistered(String registrationDate) {
        LocalDate regDate = LocalDate.parse(registrationDate);
        LocalDate currentDate = LocalDate.now();
        Period period = Period.between(regDate, currentDate);
        return period.getYears();
    }

    public static void main(String[] args) throws SQLException {
        String sourceDb = "source.db";
        String targetDb = "target.db";

        performETL(sourceDb, targetDb);
        System.out.println("ETL process completed!");
    }
}
