package com.chris1320.hds.inventorysystem.pos;

import javax.swing.JFrame;

public class InventorySystemPoS {

    public static void main(String[] args) {
        JFrame main_window = new JFrame(Info.NAME);
        main_window.setContentPane(new LoginPanel(main_window).getPanel());
        main_window.setResizable(false);
        main_window.pack();
        main_window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        main_window.setVisible(true);
    }
}
