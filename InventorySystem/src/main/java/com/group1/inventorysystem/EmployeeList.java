package com.group1.inventorysystem;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.SQLException;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;

/**
 * @author Chris
 */
public class EmployeeList extends javax.swing.JPanel {
    AssetManager asset_manager = new AssetManager();
    JFrame main_frame;
    String username;

    public EmployeeList(JFrame main_frame, String username) {
        initComponents();
        
        this.main_frame = main_frame;
        this.username = username;
        
        try {
            Connection con = SQLHandler.getConnection();
            Statement get_departments_statement = con.createStatement();
            
            // Get available departments.
            ResultSet get_departments_statement_result = get_departments_statement.executeQuery("SELECT * FROM departments");
            while (get_departments_statement_result.next()) {
                this.filter_dept.addItem(
                    get_departments_statement_result.getString("Dept_ID")
                );
            }
            
            // Get all employee information.
            Statement statement = con.createStatement();
            ResultSet employees = statement.executeQuery(
                "SELECT Employee_ID, username, First_Name, Middle_Name, Last_Name, department, is_admin FROM employees"
            );
            DefaultTableModel employee_table_model = (DefaultTableModel) employee_table.getModel();
            while (employees.next()) {
                employee_table_model.addRow(
                    new Object[]{
                        employees.getInt("Employee_ID"),
                        employees.getString("username"),
                        employees.getString("First_Name"),
                        employees.getString("Middle_Name"),
                        employees.getString("Last_name"),
                        employees.getString("department"),
                        employees.getBoolean("is_admin")
                    }
                );
            }
            employee_table.setModel(employee_table_model);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(main_frame, "Cannot connect to the database server.");
        }
    }
    
    public JPanel getPanel() {
        return this;
    }
    
    private void setFilter() {
        boolean filters_applied = false;
        String selected_dept_filter = filter_dept.getSelectedItem().toString();
        String query = "SELECT Employee_ID, username, First_Name, Middle_Name, Last_Name, department, is_admin FROM employees";
        if (filter_dept.getSelectedIndex() == 0) {}
        else {
            // Append the department name to the end of the SQL query.
            query += String.format(" WHERE department = '%s'", selected_dept_filter);
            filters_applied = true;
        }
        
        if (this.filter_admin.isSelected()) {
            if (filters_applied) query += " AND is_admin = 1";
            else {
                query += " WHERE is_admin = 1";
                filters_applied = true;
            }
        }
        
        if (this.filter_username.getText().length() != 0) {
            if (filters_applied) query += String.format(
                " AND username LIKE '%s%s%s'",
                '%',
                this.filter_username.getText(),
                '%'
            );
            else query += String.format(
                " WHERE username LIKE '%s%s%s'",
                '%',
                this.filter_username.getText(),
                '%'
            );
        }

        try {
            Connection con = SQLHandler.getConnection();
            Statement statement = con.createStatement();
            ResultSet employees = statement.executeQuery(query);
            DefaultTableModel employee_table_model = (DefaultTableModel) employee_table.getModel();
            employee_table_model.setRowCount(0);  // Remove all table content.
            while (employees.next()) {
                employee_table_model.addRow(
                    new Object[]{
                        employees.getInt("Employee_ID"),
                        employees.getString("username"),
                        employees.getString("First_Name"),
                        employees.getString("Middle_Name"),
                        employees.getString("Last_name"),
                        employees.getString("department"),
                        employees.getBoolean("is_admin")
                    }
                );
            }
            employee_table.setModel(employee_table_model);
        }
        catch (SQLException ex) {
            JOptionPane.showMessageDialog(main_frame, "Cannot set filter!");
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
        jScrollPane1 = new javax.swing.JScrollPane();
        employee_table = new javax.swing.JTable();
        back = new javax.swing.JButton();
        updateButton = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        filter_dept = new javax.swing.JComboBox<>();
        jLabel3 = new javax.swing.JLabel();
        filter_admin = new javax.swing.JCheckBox();
        filter_username = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();

        setBackground(ColorManager.EMPLOYEE_LIST_BG);

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        jLabel1.setForeground(ColorManager.TXT_LABEL_LIGHT);
        jLabel1.setIcon(asset_manager.getImageIcon("inventory.png", 50, 50));
        jLabel1.setText(Info.NAME);

        jLabel2.setFont(new java.awt.Font("JetBrains Mono", 2, 18)); // NOI18N
        jLabel2.setForeground(ColorManager.TXT_LABEL_LIGHT);
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Inventory System");

        employee_table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Employee ID", "Username", "First Name", "Middle Name", "Last Name", "Department", "Administrator"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Boolean.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(employee_table);

        back.setText("Back to Menu");
        back.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backActionPerformed(evt);
            }
        });

        updateButton.setText("Update Employee Info");
        updateButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                updateButtonActionPerformed(evt);
            }
        });

        jButton1.setText("Add Employee");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        filter_dept.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "All Departments" }));
        filter_dept.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                filter_deptFocusLost(evt);
            }
        });
        filter_dept.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                filter_deptActionPerformed(evt);
            }
        });

        jLabel3.setForeground(ColorManager.TXT_LABEL_LIGHT);
        jLabel3.setText("Show employees from");

        filter_admin.setBackground(ColorManager.EMPLOYEE_LIST_BG);
        filter_admin.setText("Only show administrators");
        filter_admin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                filter_adminActionPerformed(evt);
            }
        });

        filter_username.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                filter_usernameKeyReleased(evt);
            }
        });

        jLabel4.setText("Search username");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(19, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel1))
                        .addGap(35, 35, 35)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(filter_dept, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(6, 6, 6)
                                .addComponent(filter_admin))))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jButton1)
                        .addGap(18, 18, 18)
                        .addComponent(updateButton)
                        .addGap(36, 36, 36)
                        .addComponent(back))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 589, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(filter_username, javax.swing.GroupLayout.PREFERRED_SIZE, 174, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(24, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(22, 22, 22)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(filter_dept, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addComponent(filter_admin))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(filter_username, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 275, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 25, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(back)
                    .addComponent(updateButton)
                    .addComponent(jButton1))
                .addGap(25, 25, 25))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void backActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backActionPerformed
        main_frame.setContentPane(new DashboardAdmin(main_frame, username).getPanel());
        main_frame.pack();
        main_frame.validate();
    }//GEN-LAST:event_backActionPerformed

    private void updateButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_updateButtonActionPerformed
        main_frame.setContentPane(new EmployeeUpdate(main_frame, username).getPanel());
        main_frame.pack();
        main_frame.validate();
    }//GEN-LAST:event_updateButtonActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        main_frame.setContentPane(new EmployeeAdd(main_frame, username).getPanel());
        main_frame.pack();
        main_frame.validate();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void filter_deptFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_filter_deptFocusLost
    }//GEN-LAST:event_filter_deptFocusLost

    private void filter_deptActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_filter_deptActionPerformed
        setFilter();
    }//GEN-LAST:event_filter_deptActionPerformed

    private void filter_adminActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_filter_adminActionPerformed
        setFilter();
    }//GEN-LAST:event_filter_adminActionPerformed

    private void filter_usernameKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_filter_usernameKeyReleased
        setFilter();
    }//GEN-LAST:event_filter_usernameKeyReleased


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton back;
    private javax.swing.JTable employee_table;
    private javax.swing.JCheckBox filter_admin;
    private javax.swing.JComboBox<String> filter_dept;
    private javax.swing.JTextField filter_username;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton updateButton;
    // End of variables declaration//GEN-END:variables
}
