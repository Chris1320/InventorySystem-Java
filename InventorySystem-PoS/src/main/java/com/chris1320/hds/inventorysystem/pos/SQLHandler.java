package com.chris1320.hds.inventorysystem.pos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * This class handles all low-level SQL communications with the database server.
 *
 * @author Chris
 */
public class SQLHandler {
    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(
            Info.DB_SERVER_URL,
            Info.DB_CREDENTIALS[0], // dbusername
            Info.DB_CREDENTIALS[1] // dbpassword
        );
    }
}
