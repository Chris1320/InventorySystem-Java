package com.group1.inventorysystem;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

/**
 * @author jhazminereigne
 */
public class EmployeeAdd extends javax.swing.JPanel {
    AssetManager asset_manager = new AssetManager();
    JFrame main_frame;
    String username;
    
    boolean fnametxt_modified = false;
    boolean mnametxt_modified = false;
    boolean lnametxt_modified = false;
    
    String emp_img_path = "";

    public EmployeeAdd(JFrame main_frame, String username) {
        initComponents();
        this.main_frame = main_frame;
        this.username = username;
        
        // Show placeholder text in name.
        fnametxt.setText("First Name");
        mnametxt.setText("Middle Name");
        lnametxt.setText("Last Name");
        fnametxt.setForeground(ColorManager.PLACEHOLDER_FG);
        mnametxt.setForeground(ColorManager.PLACEHOLDER_FG);
        lnametxt.setForeground(ColorManager.PLACEHOLDER_FG);
        
        employee_image.setIcon(asset_manager.getImageIcon(
            "employee_img.png", 
            Info.EMPLOYEE_IMG_X,
            Info.EMPLOYEE_IMG_Y
        ));
        
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
    }

    public void clear() {
        fnametxt.setText("");
        mnametxt.setText("");
        lnametxt.setText("");
        usernametxt.setText("");
        passtxt.setText("");
        confirmpasstxt.setText("");
        depbox.setSelectedIndex(0);
        is_admin.setSelected(false);
        emp_img_path = "";
        employee_image.setIcon(asset_manager.getImageIcon(
            "employee_img.png", 
            Info.EMPLOYEE_IMG_X,
            Info.EMPLOYEE_IMG_Y
        ));
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
        jLabel2 = new javax.swing.JLabel();
        jCheckBox1 = new javax.swing.JCheckBox();
        username_lbl = new javax.swing.JLabel();
        employeename_lbl = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        department_lbl = new javax.swing.JLabel();
        password_lbl = new javax.swing.JLabel();
        fnametxt = new javax.swing.JTextField();
        usernametxt = new javax.swing.JTextField();
        confirmpassword_lbl = new javax.swing.JLabel();
        add = new javax.swing.JButton();
        back = new javax.swing.JButton();
        mnametxt = new javax.swing.JTextField();
        lnametxt = new javax.swing.JTextField();
        passtxt = new javax.swing.JPasswordField();
        confirmpasstxt = new javax.swing.JPasswordField();
        jLabel1 = new javax.swing.JLabel();
        depbox = new javax.swing.JComboBox<>();
        is_admin = new javax.swing.JCheckBox();
        employee_image = new javax.swing.JLabel();
        add_image = new javax.swing.JButton();

        jScrollPane1.setViewportView(jEditorPane1);

        jLabel2.setText("jLabel2");

        jCheckBox1.setText("jCheckBox1");

        setBackground(Info.COLOR_EMPLOYEE_ADD);

        username_lbl.setText("Username");

        employeename_lbl.setText("Employee Name");

        department_lbl.setText("Department");

        password_lbl.setText("Password");

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

        confirmpassword_lbl.setText("Confirm Password");

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

        depbox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                depboxActionPerformed(evt);
            }
        });

        is_admin.setText("With Admin Privileges");

        employee_image.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);

        add_image.setText("Add Image");
        add_image.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                add_imageActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(112, 112, 112)
                                .addComponent(jLabel3)
                                .addGap(60, 60, 60))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(back)
                                .addGap(44, 44, 44)))
                        .addComponent(add))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(130, 130, 130)
                        .addComponent(jLabel1))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(50, 50, 50)
                                .addComponent(employee_image, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(add_image, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(department_lbl)
                            .addComponent(employeename_lbl)
                            .addComponent(username_lbl)
                            .addComponent(password_lbl)
                            .addComponent(confirmpassword_lbl))
                        .addGap(19, 19, 19)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(usernametxt, javax.swing.GroupLayout.PREFERRED_SIZE, 352, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                        .addComponent(fnametxt)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(mnametxt, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(lnametxt, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(passtxt, javax.swing.GroupLayout.PREFERRED_SIZE, 352, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addComponent(confirmpasstxt, javax.swing.GroupLayout.PREFERRED_SIZE, 352, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(depbox, javax.swing.GroupLayout.PREFERRED_SIZE, 173, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(is_admin)))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addComponent(jLabel1)
                .addGap(18, 18, Short.MAX_VALUE)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(fnametxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(employeename_lbl)
                            .addComponent(mnametxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lnametxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(usernametxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(username_lbl))
                        .addGap(12, 12, 12)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(password_lbl)
                            .addComponent(passtxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(employee_image, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(28, 28, 28)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(confirmpassword_lbl)
                    .addComponent(confirmpasstxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(add_image))
                .addGap(22, 22, 22)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(department_lbl)
                    .addComponent(depbox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(is_admin))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 39, Short.MAX_VALUE)
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
        String firstname;
        String middlename;
        String lastname;
        if (fnametxt_modified) firstname = fnametxt.getText();
        else firstname = "";
        if (mnametxt_modified) middlename = mnametxt.getText();
        else middlename = "";
        if (lnametxt_modified) lastname = lnametxt.getText();
        else lastname = "";
        String username = usernametxt.getText();
        String password = CredentialsManager.hashMessage(passtxt.getPassword());
        String department = depbox.getSelectedItem().toString();

        if (
            !CredentialsManager.convertPasswordToString(passtxt.getPassword()).equals(
                CredentialsManager.convertPasswordToString(confirmpasstxt.getPassword())
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
            // Get the latest ID.
            int latest_id;
            Connection con = SQLHandler.getConnection();
            Statement latest_id_statement = con.createStatement();
            latest_id_statement.execute("SELECT MAX(Employee_ID) FROM employees");
            ResultSet latest_id_statement_result = latest_id_statement.getResultSet();

            if (latest_id_statement_result.next()) {
                try {
                    latest_id = Integer.parseInt(latest_id_statement_result.getString(1));
                    latest_id++;
                } catch (NumberFormatException ex) {
                    latest_id = 1;  // If there's no records in db yet.
                }
            } else {
                JOptionPane.showMessageDialog(main_frame, "Cannot get nurse ID.");
                return;
            }
            PreparedStatement statement = con.prepareStatement(
                "INSERT INTO employees VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?);"
            );
            
            statement.setInt(1, latest_id);
            statement.setString(2, firstname);
            statement.setString(3, middlename);
            statement.setString(4, lastname);
            statement.setString(5, username);
            statement.setString(6, password);
            statement.setString(7, department);
            if (is_admin.isSelected()) statement.setString(8, "1");
            else statement.setString(8, "0");
            if (this.emp_img_path.length() != 0) {
                File image_file = new File(this.emp_img_path);
                //int image_file_length = (int)image_file.length();
                FileInputStream image_stream = new FileInputStream(image_file);
                statement.setBlob(9, image_stream);
            }
            else statement.setNull(9, java.sql.Types.BLOB);

            statement.executeUpdate();
            JOptionPane.showMessageDialog(
                main_frame,
                String.format(
                    "Employee added successfully with employee ID #%s!",
                    latest_id
                )
            );
            clear();
        } catch (SQLException | IOException e) {
            JOptionPane.showMessageDialog(main_frame, "Error: " + e);
        }
    }//GEN-LAST:event_addActionPerformed

    private void backActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backActionPerformed
        main_frame.setContentPane(new DashboardAdmin(main_frame, this.username).getPanel());
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

    private void depboxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_depboxActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_depboxActionPerformed

    private void add_imageActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_add_imageActionPerformed
        JFileChooser chooser = new JFileChooser();
        chooser.showOpenDialog(null);
        File f = chooser.getSelectedFile();
        this.emp_img_path = f.getAbsolutePath();
        employee_image.setIcon(asset_manager.getExternalImageIcon(this.emp_img_path, Info.EMPLOYEE_IMG_X, Info.EMPLOYEE_IMG_Y));
    }//GEN-LAST:event_add_imageActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton add;
    private javax.swing.JButton add_image;
    private javax.swing.JButton back;
    private javax.swing.JPasswordField confirmpasstxt;
    private javax.swing.JLabel confirmpassword_lbl;
    private javax.swing.JLabel department_lbl;
    private javax.swing.JComboBox<String> depbox;
    private javax.swing.JLabel employee_image;
    private javax.swing.JLabel employeename_lbl;
    private javax.swing.JTextField fnametxt;
    private javax.swing.JCheckBox is_admin;
    private javax.swing.JCheckBox jCheckBox1;
    private javax.swing.JEditorPane jEditorPane1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField lnametxt;
    private javax.swing.JTextField mnametxt;
    private javax.swing.JPasswordField passtxt;
    private javax.swing.JLabel password_lbl;
    private javax.swing.JLabel username_lbl;
    private javax.swing.JTextField usernametxt;
    // End of variables declaration//GEN-END:variables
}
