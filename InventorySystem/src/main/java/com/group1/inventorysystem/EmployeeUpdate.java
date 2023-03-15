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

public class EmployeeUpdate extends javax.swing.JPanel {

    JFrame main_frame;

    public EmployeeUpdate(JFrame main_frame) {
        this.main_frame = main_frame;
        initComponents();
    }

    public void Clear() {
        empidtxt.setText("");
        fnametxt.setText("");
        mnametxt.setText("");
        lnametxt.setText("");
        usernametxt.setText("");
        passtxt.setText("");
        conpasstxt.setText("");
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

        back = new javax.swing.JButton();
        update = new javax.swing.JButton();
        employeename = new javax.swing.JLabel();
        mnametxt = new javax.swing.JTextField();
        department = new javax.swing.JLabel();
        lnametxt = new javax.swing.JTextField();
        employeeid = new javax.swing.JLabel();
        password = new javax.swing.JLabel();
        empidtxt = new javax.swing.JTextField();
        fnametxt = new javax.swing.JTextField();
        usernametxt = new javax.swing.JTextField();
        deptxt = new javax.swing.JTextField();
        confirmpassword = new javax.swing.JLabel();
        username = new javax.swing.JLabel();
        search = new javax.swing.JButton();
        edit = new javax.swing.JButton();
        remove = new javax.swing.JButton();
        passtxt = new javax.swing.JPasswordField();
        conpasstxt = new javax.swing.JPasswordField();
        clear = new javax.swing.JButton();

        back.setText("BACK ");
        back.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backActionPerformed(evt);
            }
        });

        update.setText("UPDATE");
        update.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                updateActionPerformed(evt);
            }
        });

        employeename.setText("Employee Name");

        mnametxt.setEditable(false);

        department.setText("Department");

        lnametxt.setEditable(false);

        employeeid.setText("Employee ID");

        password.setText("Password");

        fnametxt.setEditable(false);

        usernametxt.setEditable(false);
        usernametxt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                usernametxtActionPerformed(evt);
            }
        });

        deptxt.setEditable(false);

        confirmpassword.setText("Confirm Password");

        username.setText("Username");

        search.setText("SEARCH EMPLOYEE");
        search.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchActionPerformed(evt);
            }
        });

        edit.setText("EDIT EMPLOYEE");
        edit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editActionPerformed(evt);
            }
        });

        remove.setText("REMOVE EMPLOYEE");
        remove.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                removeActionPerformed(evt);
            }
        });

        passtxt.setEditable(false);

        conpasstxt.setEditable(false);

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
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(63, 63, 63)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(confirmpassword)
                            .addComponent(password)
                            .addComponent(department)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(60, 60, 60)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(username)
                            .addComponent(employeename)
                            .addComponent(employeeid)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(54, 54, 54)
                        .addComponent(back)
                        .addGap(34, 34, 34)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(15, 15, 15)
                        .addComponent(edit)
                        .addGap(31, 31, 31)
                        .addComponent(remove)
                        .addGap(40, 40, 40)
                        .addComponent(update))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(30, 30, 30)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(fnametxt, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(mnametxt, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(lnametxt, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(empidtxt)
                            .addComponent(usernametxt)
                            .addComponent(deptxt)
                            .addComponent(passtxt)
                            .addComponent(conpasstxt))))
                .addContainerGap(66, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(search)
                .addGap(50, 50, 50)
                .addComponent(clear)
                .addGap(114, 114, 114))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(69, 69, 69)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(employeeid)
                    .addComponent(empidtxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(24, 24, 24)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(employeename)
                    .addComponent(fnametxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(mnametxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lnametxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(29, 29, 29)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(username)
                    .addComponent(usernametxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(32, 32, 32)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(password)
                    .addComponent(passtxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(30, 30, 30)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(confirmpassword)
                    .addComponent(conpasstxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(26, 26, 26)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(department)
                    .addComponent(deptxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(search)
                    .addComponent(clear))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 26, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(back)
                    .addComponent(update)
                    .addComponent(edit)
                    .addComponent(remove))
                .addGap(24, 24, 24))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void backActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backActionPerformed
        main_frame.setContentPane(new DashboardAdmin(main_frame).getPanel());
        main_frame.pack();
        main_frame.validate();
    }//GEN-LAST:event_backActionPerformed

    private void updateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_updateActionPerformed

        String employeeID = empidtxt.getText();
        String firstname = fnametxt.getText();
        String middlename = mnametxt.getText();
        String lastname = lnametxt.getText();
        String username = usernametxt.getText();
        String password = passtxt.getText();
        String confirmpassword = conpasstxt.getText();
        String department = deptxt.getText();

        if (!password.equals(confirmpassword)) {
            JOptionPane.showMessageDialog(main_frame, "Password mismatch");
            return;
        }
        try {
            Connection con = SQLHandler.getConnection();
            Statement statement = con.createStatement();
            
            statement.executeUpdate (
                String.format(
                    "UPDATE employees SET First_Name='%s',Middle_Name='%s',Last_Name='%s',username='%s'"
                    + ",password='%s',Department='%s' WHERE Employee_ID='%s'",
                    firstname, middlename,lastname,username,password,department,employeeID));

           
            JOptionPane.showMessageDialog(null, "Employee updated successfully!!");
            Clear();

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e);

        }
    }//GEN-LAST:event_updateActionPerformed

    private void usernametxtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_usernametxtActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_usernametxtActionPerformed

    private void removeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_removeActionPerformed
        String employeeID = empidtxt.getText();
        String firstname = fnametxt.getText();
        String middlename = mnametxt.getText();
        String lastname = lnametxt.getText();
        String username = usernametxt.getText();
        String password = passtxt.getText();
        String confirmpassword = conpasstxt.getText();
        String department = deptxt.getText();

        if (!password.equals(confirmpassword)) {
            JOptionPane.showMessageDialog(main_frame, "Password mismatch");
            return;
        }
        try {
             Connection con = SQLHandler.getConnection();
            Statement statement = con.createStatement();
            statement.executeUpdate (
                String.format(
                    "DELETE  FROM `employees` WHERE Employee_ID = '%s' ",employeeID));

           
            JOptionPane.showMessageDialog(null, "Employee deleted successfully!!");
            Clear();

        } catch (SQLException  e) {
            JOptionPane.showMessageDialog(null, e);

        }
    }//GEN-LAST:event_removeActionPerformed

    private void editActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editActionPerformed
        fnametxt.setEditable(true);
        mnametxt.setEditable(true);
        lnametxt.setEditable(true);
        usernametxt.setEditable(true);
        passtxt.setEditable(true);
        conpasstxt.setEditable(true);
        deptxt.setEditable(true);
    }//GEN-LAST:event_editActionPerformed

    private void searchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchActionPerformed
        try {
            String str = empidtxt.getText();
            Connection con = SQLHandler.getConnection();
            PreparedStatement st = con.prepareStatement("select * from employees where Employee_ID=?");
            st.setString(1, str);
            //Excuting Query
            ResultSet rs = st.executeQuery();

            if (rs.next()) {
                String s = rs.getString(1);
                String s1 = rs.getString(2);
                String s2 = rs.getString(3);
                String s3 = rs.getString(4);
                String s4 = rs.getString(5);
                String s5 = rs.getString(6);
                String s6 = rs.getString(7);

                //Sets Records in TextFields.
                empidtxt.setText(s);
                fnametxt.setText(s1);
                mnametxt.setText(s2);
                lnametxt.setText(s3);
                usernametxt.setText(s4);
                passtxt.setText(s5);
                conpasstxt.setText(s5);
                deptxt.setText(s6);

            } else {
                JOptionPane.showMessageDialog(null, "Record not Found");
            } //end of iiner if
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }//GEN-LAST:event_searchActionPerformed

    private void clearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_clearActionPerformed
        Clear();
    }//GEN-LAST:event_clearActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton back;
    private javax.swing.JButton clear;
    private javax.swing.JLabel confirmpassword;
    private javax.swing.JPasswordField conpasstxt;
    private javax.swing.JLabel department;
    private javax.swing.JTextField deptxt;
    private javax.swing.JButton edit;
    private javax.swing.JTextField empidtxt;
    private javax.swing.JLabel employeeid;
    private javax.swing.JLabel employeename;
    private javax.swing.JTextField fnametxt;
    private javax.swing.JTextField lnametxt;
    private javax.swing.JTextField mnametxt;
    private javax.swing.JPasswordField passtxt;
    private javax.swing.JLabel password;
    private javax.swing.JButton remove;
    private javax.swing.JButton search;
    private javax.swing.JButton update;
    private javax.swing.JLabel username;
    private javax.swing.JTextField usernametxt;
    // End of variables declaration//GEN-END:variables
}
