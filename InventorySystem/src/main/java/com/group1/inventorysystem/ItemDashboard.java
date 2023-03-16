package com.group1.inventorysystem;

import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Blob;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

/**
 * @author Mark Kian
 */
public class ItemDashboard extends javax.swing.JPanel {

    AssetManager asset_manager = new AssetManager();
    JFrame main_frame;
    String username;

    public ItemDashboard(JFrame main_frame, String username) {
        initComponents();
        this.main_frame = main_frame;
        this.username = username;
        
        try {
            Connection connection = SQLHandler.getConnection();
            PreparedStatement dept = connection.prepareStatement("SELECT First_Name, image FROM employees WHERE username=?");
            dept.setString(1, username);
            ResultSet res = dept.executeQuery();
            
            if (!res.next()) JOptionPane.showMessageDialog(main_frame, "Cannot get user information.");
            
            greetings.setText(String.format(greetings.getText(), res.getString("First_Name")));
            Blob image = res.getBlob("image");
            if (image != null) {
                InputStream image_stream = image.getBinaryStream();
                BufferedImage img = ImageIO.read(image_stream);
                Image emp_img = new ImageIcon(img).getImage().getScaledInstance(
                    Info.EMPLOYEE_IMG_X,
                    Info.EMPLOYEE_IMG_Y,
                    Image.SCALE_SMOOTH
                );
                ImageIcon emp_icon = new ImageIcon(emp_img);
                employee_image.setIcon(emp_icon);
            }
            else {
                employee_image.setIcon(
                asset_manager.getImageIcon(
                    "employee_img.png",
                    Info.EMPLOYEE_IMG_X,
                    Info.EMPLOYEE_IMG_Y
                )
            );
            }
        }
        catch (IOException | SQLException ex) {
            JOptionPane.showMessageDialog(main_frame, "Cannot get user information: " + ex);
            employee_image.setIcon(
                asset_manager.getImageIcon(
                    "employee_img.png",
                    Info.EMPLOYEE_IMG_X,
                    Info.EMPLOYEE_IMG_Y
                )
            );
        }
    }
     public JPanel getPanel() {
        return this;  // Return itself.
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
        search = new javax.swing.JButton();
        back = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        employee_image = new javax.swing.JLabel();
        greetings = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();

        setBackground(ColorManager.ITEM_DASHBOARD_BG);

        additem.setText("Add Item");
        additem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                additemActionPerformed(evt);
            }
        });

        search.setText("Search Item");
        search.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchActionPerformed(evt);
            }
        });

        back.setText("BACK");
        back.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("JetBrains Mono", 1, 36)); // NOI18N
        jLabel1.setForeground(ColorManager.TXT_LABEL_DARK);
        jLabel1.setIcon(asset_manager.getImageIcon("inventory.png", 50, 50));
        jLabel1.setText(Info.NAME);

        employee_image.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);

        greetings.setFont(new java.awt.Font("Segoe UI", 2, 24)); // NOI18N
        greetings.setForeground(ColorManager.TXT_LABEL_DARK);
        greetings.setText("Hello, %s!");

        jLabel2.setFont(new java.awt.Font("JetBrains Mono", 2, 18)); // NOI18N
        jLabel2.setForeground(ColorManager.TXT_LABEL_DARK);
        jLabel2.setText("Inventory System");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                            .addGap(300, 300, 300)
                            .addComponent(back))
                        .addGroup(layout.createSequentialGroup()
                            .addGap(61, 61, 61)
                            .addComponent(employee_image, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(layout.createSequentialGroup()
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(greetings))
                                .addGroup(layout.createSequentialGroup()
                                    .addGap(59, 59, 59)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(additem, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(search, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addGap(83, 83, 83)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(82, 82, 82)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(54, 54, 54)
                                .addComponent(jLabel2)))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(0, 104, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(greetings)
                                .addGap(18, 18, 18)
                                .addComponent(additem)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(search))
                            .addComponent(employee_image, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(21, 21, 21)
                .addComponent(back)
                .addGap(19, 19, 19))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void additemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_additemActionPerformed
        // TODO add your handling code here:
        main_frame.setContentPane(new ItemAdd(main_frame, username).getPanel());
        main_frame.pack();
        main_frame.validate();
    }//GEN-LAST:event_additemActionPerformed

    private void searchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchActionPerformed
        // TODO add your handling code here:
        main_frame.setContentPane(new ItemUpdate(main_frame, username).getPanel());
        main_frame.pack();
        main_frame.validate();
    }//GEN-LAST:event_searchActionPerformed

    private void backActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backActionPerformed
        main_frame.setContentPane(new LoginPanel (main_frame).getPanel());
        main_frame.pack();
        main_frame.validate();
    }//GEN-LAST:event_backActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton additem;
    private javax.swing.JButton back;
    private javax.swing.JLabel employee_image;
    private javax.swing.JLabel greetings;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JButton search;
    // End of variables declaration//GEN-END:variables
}
