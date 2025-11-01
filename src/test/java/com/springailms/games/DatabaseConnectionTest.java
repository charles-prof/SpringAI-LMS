package com.springailms.games;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
// import org.springframework.test.context.ActiveProfiles;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
// Use this annotation if you use a specific profile for your postgres setup
// @ActiveProfiles("your_profile_name") 
public class DatabaseConnectionTest {

    @Autowired
    private DataSource dataSource;

    @Test
    public void testDatabaseConnection() {
        // Assert that the data source is not null
        assertNotNull(dataSource, "DataSource should be injected");

        // Try to get a connection and assert that it's not null and valid
        try (Connection connection = dataSource.getConnection()) {
            assertNotNull(connection, "Database connection should not be null");
            assertTrue(connection.isValid(1), "Database connection should be valid");
            System.out.println("Successfully connected to the database!");
        } catch (SQLException e) {
            System.err.println("Failed to connect to the database: " + e.getMessage());
            // Fail the test if a connection cannot be established
            throw new RuntimeException("Failed to establish a database connection", e);
        }
    }
}
