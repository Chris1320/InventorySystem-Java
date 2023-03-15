package com.group1.inventorysystem;

/**
 * This class includes all general information about the software.
 *
 * @author Chris
 */
public class Info {

    public static String NAME = "Inventory System";

    // if true, do not connect to the database. ! FOR DEV ENV ONLY !
    final public static boolean OFFLINE_MODE = false;

    // Database information
    final public static String DB_SERVER_HOST = "0.tcp.ap.ngrok.io";
    final public static int DB_SERVER_PORT = 18171;
    final public static String[] DB_CREDENTIALS = {"root", ""};
    final public static String DB_NAME = "InventorySystem";
    final public static String DB_SERVER_URL = String.format(
            "jdbc:mysql://localhost/%s?user=%s&password=%s&useUnicode=true&characterEncoding=UTF-8",
            DB_NAME,
            DB_CREDENTIALS[0],
            DB_CREDENTIALS[1]
    );

}
