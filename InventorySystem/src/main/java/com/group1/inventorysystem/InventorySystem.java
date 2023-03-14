package com.group1.inventorysystem;

import javax.swing.JFrame;

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
        main_window.setContentPane(new LoginPanel(main_window).getPanel());
        main_window.setResizable(false);
        main_window.pack();
        main_window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        main_window.setVisible(true);
    }
}
