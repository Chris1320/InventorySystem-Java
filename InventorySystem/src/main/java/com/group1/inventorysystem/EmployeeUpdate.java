package com.group1.inventorysystem;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class EmployeeUpdate extends javax.swing.JPanel {

    AssetManager asset_manager = new AssetManager();
    JFrame main_frame;

    public EmployeeUpdate(JFrame main_frame) {
        initComponents();
        this.main_frame = main_frame;
        
        confirmpassword_lbl.setVisible(false);
        conpasstxt.setVisible(false);
        
        try {
            Connection connection = SQLHandler.getConnection();
            Statement get_departments_statement = connection.createStatement();
            ResultSet get_departments_statement_result = get_departments_statement.executeQuery("SELECT * FROM departments");
            while (get_departments_statement_result.next()) {
                this.depbox.addItem(
                    get_departments_statement_result.getString("Dept_ID")
                );
            }
        }
        catch (SQLException ex) {
            JOptionPane.showMessageDialog(main_frame, "Cannot get available departments.");
        }
        depbox.setSelectedIndex(-1);  // deselect the options in the department combo box.
    }

    public JPanel getPanel() {
        return this;  // Return itself.
    }

    public void clear() {
        empidtxt.setText("");
        fnametxt.setText("");
        mnametxt.setText("");
        lnametxt.setText("");
        usernametxt.setText("");
        passtxt.setText("");
        conpasstxt.setText("");
        depbox.setSelectedIndex(-1);
    }

    /**
     * Toggle the edit mode of the text fields.
     * @param state true to enable edit. Otherwise, false.
     */
    public void toggleEditMode(boolean state) {
        update.setEnabled(state);
        empidtxt.setEditable(!state);
        fnametxt.setEditable(state);
        mnametxt.setEditable(state);
        lnametxt.setEditable(state);
        usernametxt.setEditable(state);
        passtxt.setEditable(state);
        depbox.setEnabled(state);
        is_admin.setEnabled(state);
        if (state) {
            edit.setText("CANCEL EDIT");
            conpasstxt.setVisible(true);
            confirmpassword_lbl.setVisible(true);
            conpasstxt.setText("");
        }
        else {
            edit.setText("EDIT EMPLOYEE");
            conpasstxt.setVisible(false);
            confirmpassword_lbl.setVisible(false);
        }
    }

    /**
     * Toggle the availability of the buttons.
     * @param state true to enable the button. Otherwise, false.
     */
    public void toggleEditable(boolean state) {
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

        back = new javax.swing.JButton();
        update = new javax.swing.JButton();
        employeename_lbl = new javax.swing.JLabel();
        mnametxt = new javax.swing.JTextField();
        department_lbl = new javax.swing.JLabel();
        lnametxt = new javax.swing.JTextField();
        employeeid_lbl = new javax.swing.JLabel();
        password_lbl = new javax.swing.JLabel();
        empidtxt = new javax.swing.JTextField();
        fnametxt = new javax.swing.JTextField();
        usernametxt = new javax.swing.JTextField();
        confirmpassword_lbl = new javax.swing.JLabel();
        username_lbl = new javax.swing.JLabel();
        search = new javax.swing.JButton();
        edit = new javax.swing.JButton();
        remove = new javax.swing.JButton();
        passtxt = new javax.swing.JPasswordField();
        conpasstxt = new javax.swing.JPasswordField();
        clear = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        depbox = new javax.swing.JComboBox<>();
        is_admin = new javax.swing.JCheckBox();

        setBackground(Info.COLOR_EMPLOYEE_UPDATE);

        back.setText("BACK ");
        back.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backActionPerformed(evt);
            }
        });

        update.setText("UPDATE");
        update.setEnabled(false);
        update.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                updateActionPerformed(evt);
            }
        });

        employeename_lbl.setText("Employee Name");

        mnametxt.setEditable(false);

        department_lbl.setText("Department");

        lnametxt.setEditable(false);

        employeeid_lbl.setText("Employee ID");

        password_lbl.setText("Password");

        fnametxt.setEditable(false);

        usernametxt.setEditable(false);
        usernametxt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                usernametxtActionPerformed(evt);
            }
        });

        confirmpassword_lbl.setText("Confirm Password");

        username_lbl.setText("Username");

        search.setText("SEARCH EMPLOYEE");
        search.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchActionPerformed(evt);
            }
        });

        edit.setText("EDIT EMPLOYEE");
        edit.setEnabled(false);
        edit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editActionPerformed(evt);
            }
        });

        remove.setText("REMOVE EMPLOYEE");
        remove.setEnabled(false);
        remove.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                removeActionPerformed(evt);
            }
        });

        passtxt.setEditable(false);

        clear.setText("CLEAR");
        clear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                clearActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        jLabel1.setIcon(asset_manager.getImageIcon("inventory.png", 50, 50));
        jLabel1.setText("Inventory System ");

        depbox.setEnabled(false);
        depbox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                depboxActionPerformed(evt);
            }
        });

        is_admin.setText("With Admin Privileges");
        is_admin.setEnabled(false);
        is_admin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                is_adminActionPerformed(evt);
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
                            .addComponent(confirmpassword_lbl)
                            .addComponent(password_lbl)
                            .addComponent(department_lbl)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(60, 60, 60)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(username_lbl)
                            .addComponent(employeename_lbl)
                            .addComponent(employeeid_lbl)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(54, 54, 54)
                        .addComponent(back)
                        .addGap(34, 34, 34)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(15, 15, 15)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(edit)
                                .addGap(31, 31, 31)
                                .addComponent(remove)
                                .addGap(40, 40, 40)
                                .addComponent(update))))
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
                            .addComponent(passtxt)
                            .addComponent(conpasstxt)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(depbox, javax.swing.GroupLayout.PREFERRED_SIZE, 182, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(is_admin)))))
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
                .addGap(15, 15, 15)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(employeeid_lbl)
                    .addComponent(empidtxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(24, 24, 24)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(employeename_lbl)
                    .addComponent(fnametxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(mnametxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lnametxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(29, 29, 29)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(username_lbl)
                    .addComponent(usernametxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(32, 32, 32)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(password_lbl)
                    .addComponent(passtxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(30, 30, 30)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(confirmpassword_lbl)
                    .addComponent(conpasstxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(department_lbl)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(is_admin)
                        .addComponent(depbox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(23, 23, 23)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(search)
                    .addComponent(clear))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 29, Short.MAX_VALUE)
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
        String password = CredentialsManager.hashMessage(passtxt.getPassword());
        String department = depbox.getSelectedItem().toString();

        if (
            !CredentialsManager.convertPasswordToString(passtxt.getPassword()).equals(
                CredentialsManager.convertPasswordToString(conpasstxt.getPassword())
            )
        ) {
            JOptionPane.showMessageDialog(main_frame, "Password mismatch");
            return;
        }

        if (username.length() < Info.MIN_USERNAME_LEN) {
            JOptionPane.showMessageDialog(
                main_frame,
                String.format(
                    "Your username should be %s+ characters long!",
                    Info.MIN_USERNAME_LEN
                )
            );
            return;
        }
        
        if (passtxt.getPassword().length < Info.MIN_PASSWORD_LEN) {
            JOptionPane.showMessageDialog(
                main_frame,
                String.format(
                    "Your password should be %s+ characters long!",
                    Info.MIN_PASSWORD_LEN
                )
            );
            return;
        }

        try {
            Connection con = SQLHandler.getConnection();
            //Statement statement = con.createStatement();
            PreparedStatement statement = con.prepareStatement(
                String.format(
                    "%s %s %s %s WHERE Employee_ID=?",
                        "UPDATE employees SET",
                        "First_Name=?, Middle_Name=?, Last_Name=?,",
                        "username=?, password=?,",
                        "Department=?, is_admin=?"
                )
            );
            
            statement.setString(1, firstname);
            statement.setString(2, middlename);
            statement.setString(3, lastname);
            statement.setString(4, username);
            statement.setString(5, password);
            statement.setString(6, department);
            if (is_admin.isSelected()) statement.setString(7, "1");
            else statement.setString(7, "0");
            statement.setString(8, employeeID);
            
            statement.executeUpdate();
            this.toggleEditMode(false);
            JOptionPane.showMessageDialog(null, "Employee updated successfully!!");
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }//GEN-LAST:event_updateActionPerformed

    private void usernametxtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_usernametxtActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_usernametxtActionPerformed

    private void removeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_removeActionPerformed
        String employeeID = empidtxt.getText();

        try {
             Connection con = SQLHandler.getConnection();
            Statement statement = con.createStatement();
            statement.executeUpdate (
                String.format(
                    "DELETE  FROM `employees` WHERE Employee_ID = '%s' ",employeeID));

            JOptionPane.showMessageDialog(null, "Employee deleted successfully!!");
            clear();
            this.toggleEditMode(false);
            this.toggleEditable(false);

        } catch (SQLException  e) {
            JOptionPane.showMessageDialog(null, e);

        }
    }//GEN-LAST:event_removeActionPerformed

    private void editActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editActionPerformed
        this.toggleEditMode(!fnametxt.isEditable());
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
                String empid = rs.getString(1);
                String fname = rs.getString(2);
                String mname = rs.getString(3);
                String lname = rs.getString(4);
                String user = rs.getString(5);
                String dep = rs.getString(7);
                is_admin.setSelected(rs.getBoolean(8));

                //Sets Records in TextFields.
                empidtxt.setText(empid);
                fnametxt.setText(fname);
                mnametxt.setText(mname);
                lnametxt.setText(lname);
                usernametxt.setText(user);
                depbox.setSelectedItem(dep);

                this.toggleEditMode(false);
                this.toggleEditable(true);
            } else {
                JOptionPane.showMessageDialog(null, "Record not Found");
            } //end of iiner if
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }//GEN-LAST:event_searchActionPerformed

    private void clearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_clearActionPerformed
        clear();
        this.toggleEditMode(false);
        this.toggleEditable(false);
    }//GEN-LAST:event_clearActionPerformed

    private void depboxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_depboxActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_depboxActionPerformed

    private void is_adminActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_is_adminActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_is_adminActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton back;
    private javax.swing.JButton clear;
    private javax.swing.JLabel confirmpassword_lbl;
    private javax.swing.JPasswordField conpasstxt;
    private javax.swing.JLabel department_lbl;
    private javax.swing.JComboBox<String> depbox;
    private javax.swing.JButton edit;
    private javax.swing.JTextField empidtxt;
    private javax.swing.JLabel employeeid_lbl;
    private javax.swing.JLabel employeename_lbl;
    private javax.swing.JTextField fnametxt;
    private javax.swing.JCheckBox is_admin;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JTextField lnametxt;
    private javax.swing.JTextField mnametxt;
    private javax.swing.JPasswordField passtxt;
    private javax.swing.JLabel password_lbl;
    private javax.swing.JButton remove;
    private javax.swing.JButton search;
    private javax.swing.JButton update;
    private javax.swing.JLabel username_lbl;
    private javax.swing.JTextField usernametxt;
    // End of variables declaration//GEN-END:variables
}
