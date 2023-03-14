package com.group1.inventorysystem;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * This class handles the login processes of the employees and administrators.
 *
 * @author Chris
 */
public class CredentialsManager {
    Connection connection;

    /**
     *
     * @throws SQLException
     */
    public CredentialsManager() throws SQLException {
        // Establish connection to the database.
        this.connection = DriverManager.getConnection(
                Info.DB_SERVER_URL,
                Info.DB_CREDENTIALS[0], // dbusername
                Info.DB_CREDENTIALS[1] // dbpassword
        );
    }

    /**
     * This method checks if the username is in the employee database,
     * and compares the password to the password in the database if it exists.
     * @param username The username of the employee.
     * @param password The password of the employee.
     * @return true if the login is successful. Otherwise, false.
     */
    public boolean employeeLogIn(String username, char[] password) {
        return false;  // TODO: Implement
    }

    /**
     * This method checks if the username is in the admin database,
     * and compares the password to the password in the database if it exists.
     * @param username The username of the employee.
     * @param password The password of the employee.
     * @return true if the login is successful. Otherwise, false.
     */
    public boolean adminLogIn(String username, char[] password) {
        return true; // TODO: Implement
    }
}
