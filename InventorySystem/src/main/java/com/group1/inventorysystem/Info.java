package com.group1.inventorysystem;

import java.awt.Color;

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
    final public static String DB_SERVER_HOST = "localhost";
    final public static int DB_SERVER_PORT = 3306;
    final public static String[] DB_CREDENTIALS = {"root", ""};
    final public static String DB_NAME = "InventorySystem";
    final public static String DB_SERVER_URL = String.format(
            "jdbc:mysql://%s:%s/%s?user=%s&password=%s&useUnicode=true&characterEncoding=UTF-8",
            DB_SERVER_HOST,
            DB_SERVER_PORT,
            DB_NAME,
            DB_CREDENTIALS[0],
            DB_CREDENTIALS[1]
    );
    
    final public static int MIN_USERNAME_LEN = 3;
    final public static int MIN_PASSWORD_LEN = 8;
    
    final public static int EMPLOYEE_IMG_X = 75;
    final public static int EMPLOYEE_IMG_Y = 75;
    
    final public static Color COLOR_ADMIN_DASHBOARD = new Color(217, 96, 117);
    final public static Color COLOR_EMPLOYEE_ADD = new Color(255, 159, 112);
    final public static Color COLOR_EMPLOYEE_UPDATE = new Color(238, 171, 162);
    final public static Color COLOR_ITEM_ADD = new Color(167, 189, 147);
    final public static Color COLOR_ITEM_DASHBOARD = new Color(41, 126, 114);
    final public static Color COLOR_ITEM_UPDATE = new Color(96, 174, 179);
    final public static Color COLOR_LOGIN_PANEL = new Color(65, 128, 143);
    
    // Where all program assets are stored.
    final public static String ASSETS_PATH = "./assets";
}
