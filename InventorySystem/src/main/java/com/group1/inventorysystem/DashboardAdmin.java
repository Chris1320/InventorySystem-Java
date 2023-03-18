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
 * @author jhazminereigne
 */
public class DashboardAdmin extends javax.swing.JPanel {

    AssetManager asset_manager = new AssetManager();
    JFrame main_frame;
    String username;

    public DashboardAdmin(JFrame main_frame, String username) {
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

        add = new javax.swing.JButton();
        update = new javax.swing.JButton();
        back = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        employee_image = new javax.swing.JLabel();
        greetings = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        update1 = new javax.swing.JButton();

        setBackground(ColorManager.ADMIN_DASHBOARD_BG);
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        add.setText("Add Employee");
        add.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addActionPerformed(evt);
            }
        });

        update.setText("Update Employee");
        update.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                updateActionPerformed(evt);
            }
        });

        back.setText("Logout");
        back.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        jLabel1.setForeground(ColorManager.TXT_LABEL_DARK);
        jLabel1.setIcon(asset_manager.getImageIcon("inventory.png", 50, 50));
        jLabel1.setText(Info.NAME);

        employee_image.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);

        greetings.setFont(new java.awt.Font("Segoe UI", 2, 24)); // NOI18N
        greetings.setForeground(ColorManager.TXT_LABEL_DARK);
        greetings.setText("Hello, %s!");

        jLabel2.setFont(new java.awt.Font("JetBrains Mono", 2, 18)); // NOI18N
        jLabel2.setForeground(ColorManager.TXT_LABEL_DARK);
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Inventory System");

        update1.setText("List All Employees");
        update1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                update1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(back)
                .addGap(34, 34, 34))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(65, 65, 65)
                        .addComponent(employee_image, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(greetings)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(update, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(add, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(update1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(106, 106, 106)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel1))))
                .addContainerGap(99, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel2)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(employee_image, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(greetings)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(add)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(update)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(update1)
                .addGap(27, 27, 27)
                .addComponent(back)
                .addGap(23, 23, 23))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void addActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addActionPerformed
        main_frame.setContentPane(new EmployeeAdd(main_frame, this.username).getPanel());
        main_frame.pack();
        main_frame.validate();
    }//GEN-LAST:event_addActionPerformed

    private void updateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_updateActionPerformed
        main_frame.setContentPane(new EmployeeUpdate(main_frame, this.username).getPanel());
        main_frame.pack();
        main_frame.validate();
    }//GEN-LAST:event_updateActionPerformed

    private void backActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backActionPerformed
        main_frame.setContentPane(new LoginPanel (main_frame).getPanel());
        main_frame.pack();
        main_frame.validate();
    }//GEN-LAST:event_backActionPerformed

    private void update1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_update1ActionPerformed
        main_frame.setContentPane(new EmployeeList (main_frame, this.username).getPanel());
        main_frame.pack();
        main_frame.validate();
    }//GEN-LAST:event_update1ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton add;
    private javax.swing.JButton back;
    private javax.swing.JLabel employee_image;
    private javax.swing.JLabel greetings;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JButton update;
    private javax.swing.JButton update1;
    // End of variables declaration//GEN-END:variables
}
