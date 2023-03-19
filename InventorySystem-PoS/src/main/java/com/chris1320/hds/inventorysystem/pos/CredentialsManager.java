package com.chris1320.hds.inventorysystem.pos;

import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.KeySpec;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Base64;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEKeySpec;

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
            this.connection = SQLHandler.getConnection();
        }
    }

    /**
     * This method checks if the username is in the employee database, and
     * compares the password to the password in the database if it exists.
     *
     * @param username The username of the employee.
     * @param password The password of the employee.
     * @return true if the login is successful. Otherwise, false.
     * @throws java.sql.SQLException
     */
    public boolean employeeLogIn(String username, char[] password) throws SQLException, NullPointerException {
        if (Info.OFFLINE_MODE) return true;
        return this.loginHandler(username, password, false);
    }

    /**
     * This method is the actual method that communicates with the database
     * server. The code of employee and administrator logins are the same except
     * for the database table names, so this method was made to minify the code
     * size.
     *
     * @param username The username of the user.
     * @param password The password of the user.
     * @param table_name The table name to query.
     * @return true if the login successful. Otherwise, false.
     */
    private boolean loginHandler(String username, char[] password, boolean as_admin) throws SQLException, NullPointerException {
        // Prepare the password query to the database.
        PreparedStatement get_username_statement = connection.prepareStatement(
            "SELECT password, is_admin FROM employees WHERE username=? AND is_active=1"
        );
        get_username_statement.setString(1, username);

        // Perform the query.
        ResultSet get_username_statement_result = get_username_statement.executeQuery();

        // If no username matched, invalid username.
        if (!get_username_statement_result.next()) {
            return false;
        }

        // If username matched, get its password.
        String user_pass = get_username_statement_result.getString("password");
        boolean is_admin = get_username_statement_result.getBoolean("is_admin");

        // If password matched, login process is successful.
        if (CredentialsManager.comparePasswords(password, user_pass)) {
            // | as_admin | is_admin | login_success |
            // |          |          |               |
            // | true     | true     | true          |
            // | true     | false    | false         |
            // | false    | true     | true          |
            // | false    | false    | true          |
            if (as_admin) return is_admin;
            return true;
        }
        else return false;
    }

    /**
     * The JPasswordField's `.getPassword()` method returns an array of
     * characters, so we have to create a helper method to convert that array
     * into a string. (The use of `.getText()` is now deprecated.)
     *
     * @param password The array of characters to convert into string.
     * @return The string version of the password.
     */
    public static String convertPasswordToString(char[] password) {
        StringBuilder result = new StringBuilder();
        for (char c : password) {
            result.append(c);
        }
        return result.toString();
    }
    
    public static boolean comparePasswords(char[] password, String hash) {
        Base64.Decoder b64decoder = Base64.getDecoder();

        String[] checksum = hash.split("\\|");
        byte[] salt = b64decoder.decode(checksum[1]);
        String password_hash = CredentialsManager.hashMessage(password, salt);
        
        return password_hash.split("\\|")[0].equals(checksum[0]);
    }
    
    /**
     * This method will hash the message using the PBKDF2 key derivation
     * algorithm.
     * 
     * @param message
     * @return An array of string that contains the hash and the salt.
     */
    public static String hashMessage(char[] message) {
        // Generate a cryptographically secure salt.
        SecureRandom rng = new SecureRandom();
        byte[] salt = new byte[16];
        rng.nextBytes(salt);
        return CredentialsManager.hashMessage(message, salt);
    }

    /**
     * This method will hash the message using the PBKDF2 key derivation
     * algorithm.
     * 
     * @param message
     * @param salt
     * @return An array of string that contains the hash and the salt.
     */
    public static String hashMessage(char[] message, byte[] salt) {
        String algorithm = "PBKDF2WithHmacSHA1";
        try {
            // We will be using the PBKDF2 with HMAC-SHA1 key derivation function.
            SecretKeyFactory secretkey_factory = SecretKeyFactory.getInstance(algorithm);

            // Hash the message with the salt.
            KeySpec spec = new PBEKeySpec(message, salt, 65536, 128);
            byte[] hash = secretkey_factory.generateSecret(spec).getEncoded();

            // Encode the hash into Base64.
            Base64.Encoder b64encoder = Base64.getEncoder();

            return String.format(
                "%s|%s",
                b64encoder.encodeToString(hash),
                b64encoder.encodeToString(salt)
            );
        } catch (NoSuchAlgorithmException |InvalidKeySpecException ex) {
            return "";  // this should never happen since
                        // we don't dynamically change the
                        // algorithm that is used.
        }
    }
}
