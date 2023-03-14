package com.group1.inventorysystem;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 * This class handles the login processes of the employees and administrators.
 *
 * @author Chris
 */
public class CredentialsManager {

    Connection connection;

    /**
     * @throws SQLException
     */
    public CredentialsManager() throws SQLException {
        if (!Info.OFFLINE_MODE) {
            // Establish connection to the database.
            this.connection = DriverManager.getConnection(
                    Info.DB_SERVER_URL,
                    Info.DB_CREDENTIALS[0], // dbusername
                    Info.DB_CREDENTIALS[1] // dbpassword
            );
        } else {
            JOptionPane.showMessageDialog(
                    null,
                    "WARNING: You are in offline mode."
            );
        }
    }

    /**
     * This method checks if the username is in the employee database, and
     * compares the password to the password in the database if it exists.
     *
     * @param username The username of the employee.
     * @param password The password of the employee.
     * @return true if the login is successful. Otherwise, false.
     */
    public boolean employeeLogIn(String username, char[] password) {
        if (Info.OFFLINE_MODE) {
            return true;
        }

        return this.loginHandler(username, password, "employees");
    }

    /**
     * This method checks if the username is in the admin database, and compares
     * the password to the password in the database if it exists.
     *
     * @param username The username of the employee.
     * @param password The password of the employee.
     * @return true if the login is successful. Otherwise, false.
     */
    public boolean adminLogIn(String username, char[] password) {
        if (Info.OFFLINE_MODE) {
            return true;
        }
        
        return this.loginHandler(username, password, "admins");
    }
    
    /**
     * This method is the actual method that communicates with the database
     * server. The code of employee and administrator logins are the same
     * except for the database table names, so this method was made to minify
     * the code size.
     * 
     * @param username The username of the user.
     * @param password The password of the user.
     * @param table_name The table name to query.
     * @return true if the login successful. Otherwise, false.
     */
    private boolean loginHandler(String username, char[] password, String table_name) {
        String wrong_password_prompt = "Invalid username/password!";

        try {
            // Prepare the password query to the database.
            PreparedStatement get_username_statement = connection.prepareStatement(
                    String.format(
                            "SELECT password FROM %s WHERE username=?",
                            table_name
                    )
            );
            get_username_statement.setString(1, username);

            // Perform the query.
            ResultSet get_username_statement_result = get_username_statement.executeQuery();

            // If no username matched, invalid username.
            if (!get_username_statement_result.next()) {
                JOptionPane.showMessageDialog(null, wrong_password_prompt);
                return false;
            }

            // If username matched, get its password.
            String user_pass = get_username_statement_result.getString(1);

            // If password matched, login process is successful.
            if (user_pass.equals(this.convertPasswordToString(password))) {
                JOptionPane.showMessageDialog(null, "Logged in!");
                return true;
            } else {
                JOptionPane.showMessageDialog(null, wrong_password_prompt);
                return false;
            }
        } catch (SQLException | NullPointerException ex) {
            JOptionPane.showMessageDialog(null, "Unable to log in.");
            return false;
        }
    }

    /**
     * The JPasswordField's `.getPassword()` method returns an array of
     * characters, so we have to create a helper method to convert that array
     * into a string. (The use of `.getText()` is now deprecated.)
     * 
     * @param password The array of characters to convert into string.
     * @return The string version of the password.
     */
    public String convertPasswordToString(char[] password) {
        StringBuilder result = new StringBuilder();
        for (char c : password) {
            result.append(c);
        }
        return result.toString();
    }
}
