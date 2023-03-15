package com.group1.inventorysystem;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

/**
 * @author jhazminereigne
 */
public class EmployeeAdd extends javax.swing.JPanel {
    AssetManager asset_manager = new AssetManager();
    JFrame main_frame;
    
    boolean fnametxt_modified = false;
    boolean mnametxt_modified = false;
    boolean lnametxt_modified = false;

    public EmployeeAdd(JFrame main_frame) {
        initComponents();
        this.main_frame = main_frame;
        
        // Show placeholder text in name.
        fnametxt.setText("First Name");
        mnametxt.setText("Middle Name");
        lnametxt.setText("Last Name");
        fnametxt.setForeground(ColorManager.PLACEHOLDER_FG);
        mnametxt.setForeground(ColorManager.PLACEHOLDER_FG);
        lnametxt.setForeground(ColorManager.PLACEHOLDER_FG);
    }

    public void clear() {
        empidtxt.setText("");
        fnametxt.setText("");
        mnametxt.setText("");
        lnametxt.setText("");
        usernametxt.setText("");
        passtxt.setText("");
        confirmpasstxt.setText("");
        deptxt.setText("");
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

        jScrollPane1 = new javax.swing.JScrollPane();
        jEditorPane1 = new javax.swing.JEditorPane();
        username = new javax.swing.JLabel();
        employeename = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        department = new javax.swing.JLabel();
        employeeid = new javax.swing.JLabel();
        password = new javax.swing.JLabel();
        empidtxt = new javax.swing.JTextField();
        fnametxt = new javax.swing.JTextField();
        usernametxt = new javax.swing.JTextField();
        deptxt = new javax.swing.JTextField();
        confirmpassword = new javax.swing.JLabel();
        add = new javax.swing.JButton();
        back = new javax.swing.JButton();
        mnametxt = new javax.swing.JTextField();
        lnametxt = new javax.swing.JTextField();
        passtxt = new javax.swing.JPasswordField();
        confirmpasstxt = new javax.swing.JPasswordField();
        jLabel1 = new javax.swing.JLabel();

        jScrollPane1.setViewportView(jEditorPane1);

        username.setText("Username");

        employeename.setText("Employee Name");

        department.setText("Department");

        employeeid.setText("Employee ID");

        password.setText("Password");

        fnametxt.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                fnametxtFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                fnametxtFocusLost(evt);
            }
        });

        usernametxt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                usernametxtActionPerformed(evt);
            }
        });

        confirmpassword.setText("Confirm Password");

        add.setText("ADD EMPLOYEE");
        add.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addActionPerformed(evt);
            }
        });

        back.setText("BACK");
        back.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backActionPerformed(evt);
            }
        });

        mnametxt.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                mnametxtFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                mnametxtFocusLost(evt);
            }
        });

        lnametxt.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                lnametxtFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                lnametxtFocusLost(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        jLabel1.setIcon(asset_manager.getImageIcon("inventory.png", 50, 50));
        jLabel1.setText("Inventory System ");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(89, 89, 89)
                        .addComponent(jLabel3)
                        .addGap(76, 76, 76))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(department)
                            .addComponent(employeename)
                            .addComponent(username)
                            .addComponent(employeeid)
                            .addComponent(password)
                            .addComponent(back)
                            .addComponent(confirmpassword))
                        .addGap(19, 19, 19)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(add)
                        .addGap(48, 48, 48))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(usernametxt, javax.swing.GroupLayout.PREFERRED_SIZE, 352, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                        .addComponent(fnametxt, javax.swing.GroupLayout.DEFAULT_SIZE, 156, Short.MAX_VALUE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(mnametxt, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(lnametxt, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(empidtxt)
                                    .addComponent(passtxt)))
                            .addComponent(confirmpasstxt, javax.swing.GroupLayout.PREFERRED_SIZE, 352, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(deptxt, javax.swing.GroupLayout.PREFERRED_SIZE, 352, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap(54, Short.MAX_VALUE))))
            .addGroup(layout.createSequentialGroup()
                .addGap(130, 130, 130)
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addComponent(jLabel1)
                .addGap(34, 34, 34)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(empidtxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(employeeid))
                .addGap(17, 17, 17)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(fnametxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(employeename)
                    .addComponent(mnametxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lnametxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(usernametxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(username))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(password)
                    .addComponent(passtxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(28, 28, 28)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(confirmpassword)
                    .addComponent(confirmpasstxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(23, 23, 23)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(department)
                    .addComponent(deptxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 36, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(add)
                    .addComponent(back))
                .addGap(26, 26, 26))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void usernametxtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_usernametxtActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_usernametxtActionPerformed

    private void addActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addActionPerformed
        String employeeID = empidtxt.getText();
        String firstname = fnametxt.getText();
        String middlename = mnametxt.getText();
        String lastname = lnametxt.getText();
        String username = usernametxt.getText();
        String password = passtxt.getText();
        String confirmpassword = confirmpasstxt.getText();
        String department = deptxt.getText();

        if (!password.equals(confirmpassword)) {
            JOptionPane.showMessageDialog(main_frame, "Password mismatch");
            return;
        }
        try {
            Connection con = SQLHandler.getConnection();
            Statement statement = con.createStatement();

            // FIXME: SQL Injection vulnerability.
            statement.executeUpdate("INSERT INTO employees VALUES('" + employeeID + "', '" + firstname + "', '" + middlename + "','"
                    + lastname + "','" + username + "', '" + password + "','" + department + "');");
            JOptionPane.showMessageDialog(main_frame, "Employee added successfully!!");
            clear();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(main_frame, "Error: " + e);
        }
    }//GEN-LAST:event_addActionPerformed

    private void backActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backActionPerformed
        main_frame.setContentPane(new DashboardAdmin(main_frame).getPanel());
        main_frame.pack();
        main_frame.validate();
    }//GEN-LAST:event_backActionPerformed

    private void fnametxtFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_fnametxtFocusGained
        if (!fnametxt_modified) {
            fnametxt.setForeground(ColorManager.TEXTFIELD_FG);
            fnametxt.setText("");
            fnametxt_modified = true;
        }
    }//GEN-LAST:event_fnametxtFocusGained

    private void fnametxtFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_fnametxtFocusLost
    }//GEN-LAST:event_fnametxtFocusLost

    private void mnametxtFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_mnametxtFocusGained
        if (!mnametxt_modified) {
            mnametxt.setForeground(ColorManager.TEXTFIELD_FG);
            mnametxt.setText("");
            mnametxt_modified = true;
        }
    }//GEN-LAST:event_mnametxtFocusGained

    private void mnametxtFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_mnametxtFocusLost
    }//GEN-LAST:event_mnametxtFocusLost

    private void lnametxtFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_lnametxtFocusGained
        if (!lnametxt_modified) {
            lnametxt.setForeground(ColorManager.TEXTFIELD_FG);
            lnametxt.setText("");
            lnametxt_modified = true;
        }
    }//GEN-LAST:event_lnametxtFocusGained

    private void lnametxtFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_lnametxtFocusLost
    }//GEN-LAST:event_lnametxtFocusLost


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton add;
    private javax.swing.JButton back;
    private javax.swing.JPasswordField confirmpasstxt;
    private javax.swing.JLabel confirmpassword;
    private javax.swing.JLabel department;
    private javax.swing.JTextField deptxt;
    private javax.swing.JTextField empidtxt;
    private javax.swing.JLabel employeeid;
    private javax.swing.JLabel employeename;
    private javax.swing.JTextField fnametxt;
    private javax.swing.JEditorPane jEditorPane1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField lnametxt;
    private javax.swing.JTextField mnametxt;
    private javax.swing.JPasswordField passtxt;
    private javax.swing.JLabel password;
    private javax.swing.JLabel username;
    private javax.swing.JTextField usernametxt;
    // End of variables declaration//GEN-END:variables
}
