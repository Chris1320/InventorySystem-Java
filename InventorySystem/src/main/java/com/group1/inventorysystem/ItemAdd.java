package com.group1.inventorysystem;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

/**
 *
 * @author Chris
 */
public class ItemAdd extends javax.swing.JPanel {

    AssetManager asset_manager = new AssetManager();
    JFrame main_frame;
    Connection connection;

    public ItemAdd(JFrame main_frame) {
        initComponents();

        this.main_frame = main_frame;
        try {
            this.connection = SQLHandler.getConnection();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(main_frame, "Error: " + ex);
        }
    }

    public JPanel getPanel() {
        return this;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        additem = new javax.swing.JButton();
        back = new javax.swing.JButton();
        itemcode = new javax.swing.JLabel();
        name = new javax.swing.JLabel();
        description = new javax.swing.JLabel();
        stocks = new javax.swing.JLabel();
        price = new javax.swing.JLabel();
        itemcodetxt = new javax.swing.JTextField();
        itemnametxt = new javax.swing.JTextField();
        descriptiontxt = new javax.swing.JTextField();
        stockstxt = new javax.swing.JTextField();
        pricetxt = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();

        additem.setText("ADD ITEM");
        additem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                additemActionPerformed(evt);
            }
        });

        back.setText("BACK");
        back.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backActionPerformed(evt);
            }
        });

        itemcode.setText("Item Code");

        name.setText("Name");

        description.setText("Description");

        stocks.setText("Stocks");

        price.setText("Price");

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        jLabel1.setIcon(asset_manager.getImageIcon("inventory.png", 50, 50));
        jLabel1.setText("Inventory System ");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(70, 70, 70)
                .addComponent(back)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 152, Short.MAX_VALUE)
                .addComponent(additem)
                .addGap(33, 33, 33))
            .addGroup(layout.createSequentialGroup()
                .addGap(58, 58, 58)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addGroup(layout.createSequentialGroup()
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(itemcode)
                                .addComponent(name))
                            .addGap(18, 18, 18)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(itemcodetxt)
                                .addComponent(itemnametxt, javax.swing.GroupLayout.DEFAULT_SIZE, 217, Short.MAX_VALUE)))
                        .addGroup(layout.createSequentialGroup()
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(description)
                                .addComponent(stocks)
                                .addComponent(price))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(descriptiontxt)
                                .addComponent(stockstxt)
                                .addComponent(pricetxt)))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(itemcode)
                                    .addComponent(itemcodetxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(47, 47, 47))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(itemnametxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(name)))
                        .addGap(21, 21, 21)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(description)
                            .addComponent(descriptiontxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(27, 27, 27)
                        .addComponent(stocks))
                    .addComponent(stockstxt, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(22, 22, 22)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(pricetxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(price))
                .addGap(29, 29, 29)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(additem)
                    .addComponent(back))
                .addGap(29, 29, 29))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void backActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backActionPerformed
        main_frame.setContentPane(new ItemDashboard(main_frame).getPanel());
        main_frame.pack();
        main_frame.validate();
    }//GEN-LAST:event_backActionPerformed

    private void additemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_additemActionPerformed
        try {
            this.connection = SQLHandler.getConnection();
            Statement get_username_statement = connection.createStatement();
            get_username_statement.execute(
            String.format(
                "INSERT INTO items VALUES ('%s','%s','%s','%s','%s')",
                itemcodetxt.getText(),
                itemnametxt.getText(),
                descriptiontxt.getText(),
                stockstxt.getText(),
                pricetxt.getText()
            ));
            JOptionPane.showMessageDialog(main_frame, "Item added successfully.");
            main_frame.setContentPane(new ItemDashboard(main_frame).getPanel());
            main_frame.pack();
            main_frame.validate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(main_frame, "Error: " + ex);
        }
    }//GEN-LAST:event_additemActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton additem;
    private javax.swing.JButton back;
    private javax.swing.JLabel description;
    private javax.swing.JTextField descriptiontxt;
    private javax.swing.JLabel itemcode;
    private javax.swing.JTextField itemcodetxt;
    private javax.swing.JTextField itemnametxt;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel name;
    private javax.swing.JLabel price;
    private javax.swing.JTextField pricetxt;
    private javax.swing.JLabel stocks;
    private javax.swing.JTextField stockstxt;
    // End of variables declaration//GEN-END:variables
}
