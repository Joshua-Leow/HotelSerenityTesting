package starter.steps.database;

import io.cucumber.java.en.Then;
import net.serenitybdd.screenplay.Actor;

import java.sql.*;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class databaseStepDefinitions {

    public static boolean checkUserExists(String user_id) {

        // JDBC URL for MySQL, includes server address, port, and database name
        String url = "jdbc:mysql://10.19.128.30:3306/onlinebanking?useSSL=false&serverTimezone=UTC";

        // Database credentials
        String username = "root";
        String password = "root";

        // Query to check if a user with the given user_id exists
        String sql = "SELECT 1 FROM user WHERE username = ?";

        try {
            // Loading the JDBC driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Establishing a connection and creating a PreparedStatement within the try-with-resources statement
            try (Connection connection = DriverManager.getConnection(url, username, password);
                 PreparedStatement statement = connection.prepareStatement(sql)) {

                // Set the user_id parameter in the SQL query
                statement.setString(1, user_id);

                // Execute the query and check if any rows are returned
                try (ResultSet resultSet = statement.executeQuery()) {
                    if (resultSet.next()) {
                        System.out.println("User with username " + user_id + " exists in the database.");
                        return true; // User exists
                    } else {
                        System.out.println("User with username " + user_id + " does not exist in the database.");
                        return false; // User does not exist
                    }
                }
            }
        } catch (ClassNotFoundException e) {
            System.out.println("MySQL JDBC driver not found.");
            e.printStackTrace();
        } catch (SQLException e) {
            System.out.println("Error connecting to the database.");
            e.printStackTrace();
        }
        // The try-with-resources statement takes care of closing the connection, so there's no need for a finally block here.
        return false;
    }

    @Then("{actor} should be able to see the record {string} in the Users table in the database")
    public void userShouldBeAbleToSeeTheRecordUsernameInTheUsersTableInTheDatabase(Actor actor, String user_id) {
        assertThat(checkUserExists(user_id)).isTrue();
    }
}
