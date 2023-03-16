package com.group1.inventorysystem;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 * This is the class the includes the main method.
 * 
 * @author Chris
 */
public class InventorySystem {
    /**
     * This is the main method.
     * @param args The command-line arguments.
     */
    public static void main(String[] args) {
        JFrame main_window = new JFrame(Info.NAME);
        AssetManager asset_manager = new AssetManager();

        if (Info.OFFLINE_MODE) JOptionPane.showMessageDialog(
            null,
            "WARNING: You are running in offline mode. Only use this in development environment."
        );

        main_window.setContentPane(new LoginPanel(main_window).getPanel());
        main_window.setResizable(false);
        main_window.setIconImage(asset_manager.getImage("ready-stock.png"));
        main_window.pack();
        main_window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        main_window.setVisible(true);
    }
}
