package com.group1.inventorysystem;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;

/**
 * @author Chris
 */
public class ItemList extends javax.swing.JPanel {
    AssetManager asset_manager = new AssetManager();
    private final String username, employee_id;
    private short filter_type = 1;
    JFrame main_frame;
    
    public ItemList(JFrame main_frame, String username, String employee_id) {
        initComponents();
        
        this.main_frame = main_frame;
        this.username = username;
        this.employee_id = employee_id;
        
        try {
            Connection con = SQLHandler.getConnection();
            Statement statement = con.createStatement();
            ResultSet items = statement.executeQuery("SELECT * FROM items WHERE archived='0'");
            DefaultTableModel item_table_model = (DefaultTableModel) item_table.getModel();
            item_table_model.setRowCount(0);  // Remove all table content.
            while (items.next()) {
                item_table_model.addRow(
                    new Object[]{
                        items.getString("Item_code"),
                        items.getString("Name"),
                        items.getString("Description"),
                        items.getInt("Stocks"),
                        items.getDouble("Price")
                    }
                );
            }
            item_table.setModel(item_table_model);
        }
        catch (SQLException ex) {
            JOptionPane.showMessageDialog(main_frame, "Cannot set filter!");
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

        filter_buttons = new javax.swing.ButtonGroup();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        item_table = new javax.swing.JTable();
        back = new javax.swing.JButton();
        updateButton = new javax.swing.JButton();
        addButton = new javax.swing.JButton();
        filter_searchbar = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        filterByItemDesc = new javax.swing.JRadioButton();
        filterByItemName = new javax.swing.JRadioButton();
        filterByItemCode = new javax.swing.JRadioButton();

        setBackground(ColorManager.ITEM_LIST_BG);

        jLabel1.setFont(new java.awt.Font("JetBrains Mono", 1, 36)); // NOI18N
        jLabel1.setForeground(ColorManager.TXT_LABEL_DARK);
        jLabel1.setIcon(asset_manager.getImageIcon("inventory.png", 50, 50));
        jLabel1.setText(Info.NAME);

        jLabel2.setFont(new java.awt.Font("JetBrains Mono", 2, 18)); // NOI18N
        jLabel2.setForeground(ColorManager.TXT_LABEL_DARK);
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Inventory System");

        item_table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Item Code", "Item Name", "Description", "Stock", "Price"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Integer.class, java.lang.Double.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(item_table);

        back.setText("Back to Menu");
        back.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backActionPerformed(evt);
            }
        });

        updateButton.setText("Update Item Info");
        updateButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                updateButtonActionPerformed(evt);
            }
        });

        addButton.setText("Add Item");
        addButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addButtonActionPerformed(evt);
            }
        });

        filter_searchbar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                filter_searchbarKeyReleased(evt);
            }
        });

        jLabel4.setText("Search");

        filterByItemDesc.setBackground(ColorManager.ITEM_LIST_BG);
        filter_buttons.add(filterByItemDesc);
        filterByItemDesc.setForeground(ColorManager.TXT_LABEL_DARK);
        filterByItemDesc.setText("Search by Description");
        filterByItemDesc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                filterByItemDescActionPerformed(evt);
            }
        });

        filterByItemName.setBackground(ColorManager.ITEM_LIST_BG);
        filter_buttons.add(filterByItemName);
        filterByItemName.setForeground(ColorManager.TXT_LABEL_DARK);
        filterByItemName.setText("Search by Item Name");
        filterByItemName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                filterByItemNameActionPerformed(evt);
            }
        });

        filterByItemCode.setBackground(ColorManager.ITEM_LIST_BG);
        filter_buttons.add(filterByItemCode);
        filterByItemCode.setForeground(ColorManager.TXT_LABEL_DARK);
        filterByItemCode.setSelected(true);
        filterByItemCode.setText("Search by Item Code");
        filterByItemCode.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                filterByItemCodeActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(addButton)
                        .addGap(18, 18, 18)
                        .addComponent(updateButton)
                        .addGap(36, 36, 36)
                        .addComponent(back))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 589, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(jLabel4)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel2)
                                    .addComponent(jLabel1))
                                .addGap(104, 104, 104)))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(filterByItemDesc)
                            .addComponent(filter_searchbar, javax.swing.GroupLayout.PREFERRED_SIZE, 174, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(filterByItemName)
                            .addComponent(filterByItemCode))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel1)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(filterByItemCode)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(filterByItemName)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addComponent(filterByItemDesc))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(filter_searchbar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 275, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(back)
                    .addComponent(updateButton)
                    .addComponent(addButton))
                .addGap(25, 25, 25))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void backActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backActionPerformed
        main_frame.setContentPane(new ItemDashboard(main_frame, username).getPanel());
        main_frame.pack();
        main_frame.validate();
    }//GEN-LAST:event_backActionPerformed

    private void updateButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_updateButtonActionPerformed
        main_frame.setContentPane(new ItemUpdate(main_frame, username, employee_id).getPanel());
        main_frame.pack();
        main_frame.validate();
    }//GEN-LAST:event_updateButtonActionPerformed

    private void addButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addButtonActionPerformed
        main_frame.setContentPane(new ItemAdd(main_frame, username, employee_id).getPanel());
        main_frame.pack();
        main_frame.validate();
    }//GEN-LAST:event_addButtonActionPerformed

    private void filter_searchbarKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_filter_searchbarKeyReleased
        String query = "SELECT * FROM items WHERE archived='0'";
        switch (this.filter_type) {
            case 1:
            default:  // set case 1 as the default.
                query += String.format(
                    " AND Item_code LIKE '%s%s%s'",
                    '%', filter_searchbar.getText(), '%'
                );
                break;
            case 2:
                query += String.format(
                " AND Name LIKE '%s%s%s'",
                    '%', filter_searchbar.getText(), '%'
                );
                break;
            case 3:
                query += String.format(
                " AND Description LIKE '%s%s%s'",
                    '%', filter_searchbar.getText(), '%'
                );
                break;
        }

        try {
            Connection con = SQLHandler.getConnection();
            Statement statement = con.createStatement();
            ResultSet items = statement.executeQuery(query);
            DefaultTableModel item_table_model = (DefaultTableModel) item_table.getModel();
            item_table_model.setRowCount(0);  // Remove all table content.
            while (items.next()) {
                item_table_model.addRow(
                    new Object[]{
                        items.getString("Item_code"),
                        items.getString("Name"),
                        items.getString("Description"),
                        items.getInt("Stocks"),
                        items.getDouble("Price")
                    }
                );
            }
            item_table.setModel(item_table_model);
        }
        catch (SQLException ex) {
            JOptionPane.showMessageDialog(main_frame, "Cannot set filter!");
        }
    }//GEN-LAST:event_filter_searchbarKeyReleased

    private void filterByItemNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_filterByItemNameActionPerformed
        this.filter_type = 2;
    }//GEN-LAST:event_filterByItemNameActionPerformed

    private void filterByItemDescActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_filterByItemDescActionPerformed
        this.filter_type = 3;
    }//GEN-LAST:event_filterByItemDescActionPerformed

    private void filterByItemCodeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_filterByItemCodeActionPerformed
        this.filter_type = 1;
    }//GEN-LAST:event_filterByItemCodeActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addButton;
    private javax.swing.JButton back;
    private javax.swing.JRadioButton filterByItemCode;
    private javax.swing.JRadioButton filterByItemDesc;
    private javax.swing.JRadioButton filterByItemName;
    private javax.swing.ButtonGroup filter_buttons;
    private javax.swing.JTextField filter_searchbar;
    private javax.swing.JTable item_table;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton updateButton;
    // End of variables declaration//GEN-END:variables
}
