package com.group1.inventorysystem;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

/**
 *
 * @author Mark Kian
 */
public class ItemSearch extends javax.swing.JPanel {

    JFrame main_frame;
    Connection connection;

    /**
     * Creates new form search
     */
    public ItemSearch(JFrame main_frame) {
        initComponents();
        this.main_frame = main_frame;

        try {
            this.connection = SQLHandler.getConnection();
        } catch (SQLException | NullPointerException ex) {
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

        search = new javax.swing.JButton();
        itemcode = new javax.swing.JLabel();
        name = new javax.swing.JLabel();
        description = new javax.swing.JLabel();
        stocks = new javax.swing.JLabel();
        price = new javax.swing.JLabel();
        back = new javax.swing.JButton();
        itemcodetxt = new javax.swing.JTextField();
        nametxt = new javax.swing.JTextField();
        descriptiontxt = new javax.swing.JTextField();
        stockstxt = new javax.swing.JTextField();
        pricetxt = new javax.swing.JTextField();
        edit = new javax.swing.JButton();
        save = new javax.swing.JButton();

        search.setText("SEARCH ITEM");
        search.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchActionPerformed(evt);
            }
        });

        itemcode.setText("Item Code");

        name.setText("Name");

        description.setText("Description");

        stocks.setText("Stocks");

        price.setText("Price");

        back.setText("BACK");
        back.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backActionPerformed(evt);
            }
        });

        nametxt.setEditable(false);

        descriptiontxt.setEditable(false);

        stockstxt.setEditable(false);

        pricetxt.setEditable(false);

        edit.setText("EDIT/REMOVE");
        edit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editActionPerformed(evt);
            }
        });

        save.setText("SAVE");
        save.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saveActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(32, 32, 32)
                        .addComponent(back))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(46, 46, 46)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(price, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(name)
                            .addComponent(itemcode)
                            .addComponent(description)
                            .addComponent(stocks))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 22, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(itemcodetxt, javax.swing.GroupLayout.PREFERRED_SIZE, 176, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(nametxt, javax.swing.GroupLayout.PREFERRED_SIZE, 176, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(descriptiontxt, javax.swing.GroupLayout.PREFERRED_SIZE, 176, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(stockstxt, javax.swing.GroupLayout.PREFERRED_SIZE, 176, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(pricetxt, javax.swing.GroupLayout.PREFERRED_SIZE, 176, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(11, 11, 11)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(search)
                            .addComponent(edit))
                        .addGap(43, 43, 43)
                        .addComponent(save)))
                .addGap(61, 61, 61))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(71, 71, 71)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(itemcode)
                                .addGap(23, 23, 23))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(itemcodetxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)))
                        .addComponent(nametxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(name))
                .addGap(21, 21, 21)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(descriptiontxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(description))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(stockstxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(stocks))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(pricetxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(price))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 40, Short.MAX_VALUE)
                .addComponent(search)
                .addGap(32, 32, 32)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(back)
                    .addComponent(edit)
                    .addComponent(save))
                .addGap(30, 30, 30))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void searchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchActionPerformed
        try {
            // Prepare the password query to the database.
            PreparedStatement get_item_info = connection.prepareStatement(
                    String.format(
                            "SELECT * FROM items WHERE Item_code=?"
                    )
            );
            get_item_info.setString(1, itemcodetxt.getText());

            // Perform the query.
            ResultSet item_info = get_item_info.executeQuery();

            // If no username matched, invalid username.
            if (!item_info.next()) {
                JOptionPane.showMessageDialog(main_frame, "no item found");
            }

            // If password matched, login process is successful.
            nametxt.setText(item_info.getString("Name"));
            descriptiontxt.setText(item_info.getString("Description"));
            stockstxt.setText(item_info.getString("Stocks"));
            pricetxt.setText(item_info.getString("Price"));
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(main_frame, ex);
        }
    }

    private void additemActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
        try {
            this.connection = SQLHandler.getConnection();
            Statement get_username_statement = connection.createStatement();
            get_username_statement.execute(
                    String.format(
                            "INSERT INTO items VALUES ('%s','%s','%s','%s','%s')",
                            itemcodetxt.getText(),
                            nametxt.getText(),
                            descriptiontxt.getText(),
                            stockstxt.getText(),
                            pricetxt.getText()
                    )
            );
            // Perform the query.
        } catch (SQLException | NullPointerException ex) {
            JOptionPane.showMessageDialog(main_frame, "Error: " + ex);
        }


    }//GEN-LAST:event_searchActionPerformed

    private void backActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backActionPerformed
        main_frame.setContentPane(new EmployeeDashboard(main_frame).getPanel());
        main_frame.pack();
        main_frame.validate();
    }//GEN-LAST:event_backActionPerformed

    private void saveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveActionPerformed
        // TODO add your handling code here:
        
        String itemcode = itemcodetxt.getText();
        String name = nametxt.getText();
        String description = descriptiontxt.getText();
        String stocks = stockstxt.getText();
        String price = pricetxt.getText();

        if (!password.equals(confirmpassword)) {
            JOptionPane.showMessageDialog(main_frame, "Password mismatch");
            return;
        }
        try {
            Connection con = SQLHandler.getConnection();
            Statement statement = con.createStatement();
            
            statement.executeUpdate (
                String.format(
                    "UPDATE `employees` SET `Item_code`='%s',"
                    + "`Name`='%s',`Description`='%s',`Stocks,'Price'`='%s',"
                    + "`username`='%s',`password`='%s',`Department`='%s'",
                    itemcode, name,description,stocks,price));

           
            JOptionPane.showMessageDialog(null, "Employee updated successfully!!");
            Clear();

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e);

        }
    }                              
        main_frame.setContentPane(new EmployeeDashboard(main_frame).getPanel());
        main_frame.pack();
        main_frame.validate();
    }//GEN-LAST:event_saveActionPerformed

    private void editActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editActionPerformed
        // TODO add your handling code here:
        main_frame.setContentPane(new EmployeeDashboard(main_frame).getPanel());
        main_frame.pack();
        main_frame.validate();
    }//GEN-LAST:event_editActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton back;
    private javax.swing.JLabel description;
    private javax.swing.JTextField descriptiontxt;
    private javax.swing.JButton edit;
    private javax.swing.JLabel itemcode;
    private javax.swing.JTextField itemcodetxt;
    private javax.swing.JLabel name;
    private javax.swing.JTextField nametxt;
    private javax.swing.JLabel price;
    private javax.swing.JTextField pricetxt;
    private javax.swing.JButton save;
    private javax.swing.JButton search;
    private javax.swing.JLabel stocks;
    private javax.swing.JTextField stockstxt;
    // End of variables declaration//GEN-END:variables
}
