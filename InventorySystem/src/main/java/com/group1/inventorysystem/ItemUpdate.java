package com.group1.inventorysystem;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

/**
 * @author Mark Kian
 */
public class ItemUpdate extends javax.swing.JPanel {

    JFrame main_frame;

    public ItemUpdate(JFrame main_frame) {
        initComponents();
        this.main_frame = main_frame;
    }

    public JPanel getPanel() {
        return this;
    }

    public void clear() {
        itemcodetxt.setText("");
        nametxt.setText("");
        descriptiontxt.setText("");
        stockstxt.setText("");
        pricetxt.setText("");
    }

    /**
     * Toggle the edit mode of the text fields.
     * @param state true to enable edit. Otherwise, false.
     */
    public void toggleEditMode(boolean state) {
        nametxt.setEditable(state);
        descriptiontxt.setEditable(state);
        stockstxt.setEditable(state);
        pricetxt.setEditable(state);
        if (state) edit.setText("CANCEL EDIT");
        else edit.setText("EDIT ITEM");
    }
    
    public void toggleEditable(boolean state) {
        update.setEnabled(state);
        edit.setEnabled(state);
        remove.setEnabled(state);
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
        itemcode_lbl = new javax.swing.JLabel();
        name_lbl = new javax.swing.JLabel();
        description_lbl = new javax.swing.JLabel();
        stocks_lbl = new javax.swing.JLabel();
        price_lbl = new javax.swing.JLabel();
        back = new javax.swing.JButton();
        itemcodetxt = new javax.swing.JTextField();
        nametxt = new javax.swing.JTextField();
        descriptiontxt = new javax.swing.JTextField();
        stockstxt = new javax.swing.JTextField();
        pricetxt = new javax.swing.JTextField();
        edit = new javax.swing.JButton();
        update = new javax.swing.JButton();
        remove = new javax.swing.JButton();
        clear = new javax.swing.JButton();

        search.setText("SEARCH ITEM");
        search.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchActionPerformed(evt);
            }
        });

        itemcode_lbl.setText("Item Code");

        name_lbl.setText("Name");

        description_lbl.setText("Description");

        stocks_lbl.setText("Stocks");

        price_lbl.setText("Price");

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

        edit.setText("EDIT ITEM");
        edit.setEnabled(false);
        edit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editActionPerformed(evt);
            }
        });

        update.setText("UPDATE");
        update.setEnabled(false);
        update.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                updateActionPerformed(evt);
            }
        });

        remove.setText("REMOVE ITEM");
        remove.setEnabled(false);
        remove.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                removeActionPerformed(evt);
            }
        });

        clear.setText("CLEAR");
        clear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                clearActionPerformed(evt);
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
                            .addComponent(price_lbl, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(name_lbl)
                            .addComponent(itemcode_lbl)
                            .addComponent(description_lbl)
                            .addComponent(stocks_lbl))))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(edit)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(remove)
                        .addGap(18, 18, 18)
                        .addComponent(update))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(27, 27, 27)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(itemcodetxt, javax.swing.GroupLayout.PREFERRED_SIZE, 176, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(nametxt, javax.swing.GroupLayout.PREFERRED_SIZE, 176, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(descriptiontxt, javax.swing.GroupLayout.PREFERRED_SIZE, 176, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(stockstxt, javax.swing.GroupLayout.PREFERRED_SIZE, 176, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(pricetxt, javax.swing.GroupLayout.PREFERRED_SIZE, 176, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(34, 34, 34))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(search)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(clear)
                .addGap(71, 71, 71))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(71, 71, 71)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(itemcode_lbl)
                                .addGap(23, 23, 23))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(itemcodetxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)))
                        .addComponent(nametxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(name_lbl))
                .addGap(21, 21, 21)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(descriptiontxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(description_lbl))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(stockstxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(stocks_lbl))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(pricetxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(price_lbl))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 40, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(search)
                    .addComponent(clear))
                .addGap(32, 32, 32)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(back)
                    .addComponent(edit)
                    .addComponent(update)
                    .addComponent(remove))
                .addGap(30, 30, 30))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void searchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchActionPerformed
        try {
            String str = itemcodetxt.getText();
            Connection con = SQLHandler.getConnection();
            PreparedStatement st = con.prepareStatement("SELECT * FROM items WHERE Item_code=?");
            st.setString(1, str);
            ResultSet rs = st.executeQuery();  // Excuting Query

            if (rs.next()) {
                // Sets Records in TextFields.
                itemcodetxt.setText(rs.getString(1));
                nametxt.setText(rs.getString(2));
                descriptiontxt.setText(rs.getString(3));
                stockstxt.setText(rs.getString(4));
                pricetxt.setText(rs.getString(5));
                toggleEditMode(false);  // Disable edit if enabled.
                toggleEditable(true);  // Allow to user to enter edit mode.
            } else {
                JOptionPane.showMessageDialog(main_frame, "Record not Found");
            } //end of iiner if
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(main_frame, "Error: " + e);
        }
    }//GEN-LAST:event_searchActionPerformed

    private void backActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backActionPerformed
        main_frame.setContentPane(new ItemDashboard(main_frame).getPanel());
        main_frame.pack();
        main_frame.validate();
    }//GEN-LAST:event_backActionPerformed

    private void updateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_updateActionPerformed
        String itemcode = itemcodetxt.getText();
        String name = nametxt.getText();
        String description = descriptiontxt.getText();
        String stocks = stockstxt.getText();
        String price = pricetxt.getText();

        try {
            Connection con = SQLHandler.getConnection();
            Statement statement = con.createStatement();

            statement.executeUpdate(
                String.format(
                    "UPDATE items SET Name='%s',Description='%s',Stocks='%s',Price='%s' WHERE Item_code='%s'",
                    name,
                    description,
                    stocks,
                    price,
                    itemcode
                )
            );

            JOptionPane.showMessageDialog(main_frame, "Item updated successfully!!");
            this.toggleEditMode(false);
            this.toggleEditable(true);
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(main_frame, "Error: " + e);
        }
    }//GEN-LAST:event_updateActionPerformed

    private void editActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editActionPerformed
        this.toggleEditMode(!nametxt.isEditable());
    }//GEN-LAST:event_editActionPerformed

    private void removeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_removeActionPerformed
        try {
            Connection con = SQLHandler.getConnection();
            Statement statement = con.createStatement();

            statement.executeUpdate(String.format("DELETE FROM items WHERE Item_code = '%s'", itemcodetxt.getText()));
            JOptionPane.showMessageDialog(main_frame, "Item deleted successfully!!");
            clear();
            toggleEditMode(false);  // Disable edit if enabled.
            toggleEditable(false);
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(main_frame, "Error: " + e);
        }
    }//GEN-LAST:event_removeActionPerformed

    private void clearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_clearActionPerformed
        clear();
        toggleEditMode(false);  // Disable edit if enabled.
        toggleEditable(false);
    }//GEN-LAST:event_clearActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton back;
    private javax.swing.JButton clear;
    private javax.swing.JLabel description_lbl;
    private javax.swing.JTextField descriptiontxt;
    private javax.swing.JButton edit;
    private javax.swing.JLabel itemcode_lbl;
    private javax.swing.JTextField itemcodetxt;
    private javax.swing.JLabel name_lbl;
    private javax.swing.JTextField nametxt;
    private javax.swing.JLabel price_lbl;
    private javax.swing.JTextField pricetxt;
    private javax.swing.JButton remove;
    private javax.swing.JButton search;
    private javax.swing.JLabel stocks_lbl;
    private javax.swing.JTextField stockstxt;
    private javax.swing.JButton update;
    // End of variables declaration//GEN-END:variables
}