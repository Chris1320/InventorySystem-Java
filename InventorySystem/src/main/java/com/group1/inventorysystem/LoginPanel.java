package com.group1.inventorysystem;

import java.awt.event.KeyEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

/**
 * This is the main panel.
 *
 * @author Chris
 */
public class LoginPanel extends javax.swing.JPanel {

    JFrame main_frame;
    AssetManager asset_manager;
    CredentialsManager creds;

    /**
     * @param main_frame The parent JFrame.
     */
    public LoginPanel(JFrame main_frame) {
        this.asset_manager = new AssetManager();
        initComponents();

        this.main_frame = main_frame;
        try {
            this.creds = new CredentialsManager();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(
                    main_frame,
                    "Unable to connect to the database server: " + e.getMessage()
            );
        }
    }

    /**
     * Return the panel.
     *
     * @return
     */
    public JPanel getPanel() {
        return this;  // Return itself.
    }

    public void logIn() {
        if (this.creds == null) {
            JOptionPane.showMessageDialog(main_frame, "Unable to connect to the database server.");
            return;
        }
        try {
            if (this.creds.employeeLogIn(this.username.getText(), this.password.getPassword())) {
                main_frame.setContentPane(new ItemDashboard(main_frame, this.username.getText()).getPanel());
                main_frame.pack();
                main_frame.validate();
            } else {
                JOptionPane.showMessageDialog(main_frame, "Invalid employee username/password!");
            }
        } catch (SQLException | NullPointerException ex) {
            JOptionPane.showMessageDialog(main_frame, "Unable to log in: " + ex);
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        username = new javax.swing.JTextField();
        password = new javax.swing.JPasswordField();
        employee_log_in = new javax.swing.JButton();
        admin_log_in = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();

        setBackground(ColorManager.LOGIN_PANEL_BG);

        jLabel1.setFont(new java.awt.Font("JetBrains Mono ExtraBold", 1, 36)); // NOI18N
        jLabel1.setForeground(ColorManager.TXT_LABEL_DARK);
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setIcon(asset_manager.getImageIcon("inventory.png", 50, 50));
        jLabel1.setText(Info.NAME);

        jLabel2.setFont(new java.awt.Font("JetBrains Mono Light", 0, 14)); // NOI18N
        jLabel2.setForeground(ColorManager.TXT_LABEL_DARK);
        jLabel2.setIcon(asset_manager.getImageIcon("user-interface.png", 20, 20));
        jLabel2.setText("Username");

        jLabel3.setFont(new java.awt.Font("JetBrains Mono Light", 0, 14)); // NOI18N
        jLabel3.setForeground(ColorManager.TXT_LABEL_DARK);
        jLabel3.setIcon(asset_manager.getImageIcon("padlock.png", 20, 20));
        jLabel3.setText("Password");

        username.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                usernameFocusLost(evt);
            }
        });
        username.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                usernameActionPerformed(evt);
            }
        });
        username.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                usernameKeyPressed(evt);
            }
        });

        password.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                passwordActionPerformed(evt);
            }
        });
        password.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                passwordKeyPressed(evt);
            }
        });

        employee_log_in.setFont(new java.awt.Font("JetBrains Mono Light", 0, 12)); // NOI18N
        employee_log_in.setIcon(asset_manager.getImageIcon("login.png", 22, 22));
        employee_log_in.setText("Log In");
        employee_log_in.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                employee_log_inActionPerformed(evt);
            }
        });

        admin_log_in.setFont(new java.awt.Font("JetBrains Mono Light", 0, 12)); // NOI18N
        admin_log_in.setIcon(asset_manager.getImageIcon("setting.png", 20, 20));
        admin_log_in.setText("Admin");
        admin_log_in.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                admin_log_inActionPerformed(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("JetBrains Mono", 2, 18)); // NOI18N
        jLabel4.setForeground(ColorManager.TXT_LABEL_DARK);
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("Inventory System");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(103, 103, 103)
                        .addComponent(jLabel1))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(122, 122, 122)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(username)
                            .addComponent(password, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(123, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(admin_log_in, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(employee_log_in, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(37, 37, 37))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addGap(134, 134, 134))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(37, 37, 37)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel4)
                .addGap(33, 33, 33)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(username, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(password, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(employee_log_in)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(admin_log_in)
                .addContainerGap(26, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void passwordActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_passwordActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_passwordActionPerformed

    private void employee_log_inActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_employee_log_inActionPerformed
        logIn();
    }//GEN-LAST:event_employee_log_inActionPerformed

    private void admin_log_inActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_admin_log_inActionPerformed
        if (this.creds == null) {
            JOptionPane.showMessageDialog(main_frame, "Unable to connect to the database server.");
            return;
        }
        try {
            if (this.creds.adminLogIn(this.username.getText(), this.password.getPassword())) {
                main_frame.setContentPane(
                        new DashboardAdmin(
                                main_frame,
                                this.username.getText()
                        ).getPanel()
                );
                main_frame.validate();
            } else {
                JOptionPane.showMessageDialog(main_frame, "Invalid admin username/password!");
            }
        } catch (SQLException | NullPointerException ex) {
            JOptionPane.showMessageDialog(main_frame, "Unable to log in: " + ex);
        }
    }//GEN-LAST:event_admin_log_inActionPerformed

    private void usernameKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_usernameKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER)
            logIn();
    }//GEN-LAST:event_usernameKeyPressed

    private void passwordKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_passwordKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER)
            logIn();
    }//GEN-LAST:event_passwordKeyPressed

    private void usernameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_usernameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_usernameActionPerformed

    private void usernameFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_usernameFocusLost
        if (username.getText().length() == 0)
            admin_log_in.setEnabled(true);
        else {
            try {
                Connection is_admin_connection = SQLHandler.getConnection();
                PreparedStatement is_admin_statement = is_admin_connection.prepareStatement(
                        "SELECT is_admin, is_active FROM employees WHERE username=?"
                );
                is_admin_statement.setString(1, username.getText());
                ResultSet is_admin_result = is_admin_statement.executeQuery();
                if (is_admin_result.next()) {
                    boolean user_is_admin = is_admin_result.getBoolean("is_admin");
                    boolean user_is_enabled = is_admin_result.getBoolean("is_active");
                    admin_log_in.setEnabled(user_is_admin && user_is_enabled);
                    employee_log_in.setEnabled(user_is_enabled);
                }
            } catch (SQLException ex) {}  // Do nothing.
        }
    }//GEN-LAST:event_usernameFocusLost


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton admin_log_in;
    private javax.swing.JButton employee_log_in;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPasswordField password;
    private javax.swing.JTextField username;
    // End of variables declaration//GEN-END:variables
}
