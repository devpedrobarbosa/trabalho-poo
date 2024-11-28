/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package br.edu.veigadealmeida.trabalho.view.employee;

import br.edu.veigadealmeida.trabalho.Main;
import br.edu.veigadealmeida.trabalho.manager.EmployeeManager;
import br.edu.veigadealmeida.trabalho.model.Employee;
import br.edu.veigadealmeida.trabalho.model.enums.Department;
import br.edu.veigadealmeida.trabalho.util.Util;
import br.edu.veigadealmeida.trabalho.view.AdminAppView;
import java.util.Arrays;
import javax.swing.DefaultComboBoxModel;

/**
 *
 * @author Pedro
 */
public class EditEmployeeView extends javax.swing.JFrame {

    private final EmployeeManager manager;
    private final Employee employee;
    
    /**
     * Creates new form EditEmployeeView
     * @param manager
     * @param employee
     */
    public EditEmployeeView(EmployeeManager manager, Employee employee) {
        initComponents();
        setLocationRelativeTo(null);
        this.manager = manager;
        this.employee = employee;
        nameField.setText(employee.getName());
        documentField.setText(employee.getDocument());
        addressField.setText(employee.getAddress());
        phoneField.setText(employee.getPhone());
        emailField.setText(employee.getEmail());
        loginField.setText(employee.getLogin());
        passwordField.setText(employee.getPassword());
        departmentSelector.setModel(new DefaultComboBoxModel<>(Arrays.stream(Department.values()).map(Department::name).toList().toArray(new String[0])));
        departmentSelector.setSelectedItem(employee.getDepartment().name());
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panel = new javax.swing.JPanel();
        title = new javax.swing.JLabel();
        nameLabel = new javax.swing.JLabel();
        nameInfo = new javax.swing.JLabel();
        mandatoryField1 = new javax.swing.JLabel();
        nameField = new javax.swing.JTextField();
        documentLabel = new javax.swing.JLabel();
        documentInfo = new javax.swing.JLabel();
        mandatoryField7 = new javax.swing.JLabel();
        documentField = new javax.swing.JFormattedTextField();
        addressLabel = new javax.swing.JLabel();
        addressInfo = new javax.swing.JLabel();
        mandatoryField = new javax.swing.JLabel();
        addressField = new javax.swing.JTextField();
        phoneLabel = new javax.swing.JLabel();
        phoneInfo = new javax.swing.JLabel();
        mandatoryField2 = new javax.swing.JLabel();
        phoneField = new javax.swing.JFormattedTextField();
        emailLabel = new javax.swing.JLabel();
        emailInfo = new javax.swing.JLabel();
        mandatoryField3 = new javax.swing.JLabel();
        emailField = new javax.swing.JTextField();
        loginLabel = new javax.swing.JLabel();
        loginInfo = new javax.swing.JLabel();
        mandatoryField4 = new javax.swing.JLabel();
        loginField = new javax.swing.JTextField();
        passwordLabel = new javax.swing.JLabel();
        passwordInfo = new javax.swing.JLabel();
        mandatoryField5 = new javax.swing.JLabel();
        passwordField = new javax.swing.JTextField();
        departmentLabel = new javax.swing.JLabel();
        mandatoryField6 = new javax.swing.JLabel();
        departmentSelector = new javax.swing.JComboBox<>();
        editButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setResizable(false);

        panel.setMinimumSize(new java.awt.Dimension(450, 325));
        panel.setPreferredSize(new java.awt.Dimension(450, 325));
        panel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        title.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        title.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        title.setText("Editar Funcionário");
        panel.add(title, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 10, 450, -1));

        nameLabel.setText("Nome");
        panel.add(nameLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 50, -1, -1));

        nameInfo.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        nameInfo.setText("(?)");
        nameInfo.setToolTipText("Primeira letra maiúscula, pode conter somente letras, ' e -");
        panel.add(nameInfo, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 50, -1, -1));

        mandatoryField1.setForeground(new java.awt.Color(255, 0, 0));
        mandatoryField1.setText("*");
        mandatoryField1.setToolTipText("Campo obrigatório");
        panel.add(mandatoryField1, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 50, -1, -1));

        nameField.setToolTipText("");
        panel.add(nameField, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 70, 140, -1));

        documentLabel.setText("Documento");
        panel.add(documentLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 100, -1, -1));

        documentInfo.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        documentInfo.setText("(?)");
        documentInfo.setToolTipText("XXX.XXX.XXX-XX");
        panel.add(documentInfo, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 100, -1, -1));

        mandatoryField7.setForeground(new java.awt.Color(255, 0, 0));
        mandatoryField7.setText("*");
        mandatoryField7.setToolTipText("Campo obrigatório");
        panel.add(mandatoryField7, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 100, -1, -1));

        try {
            documentField.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("###.###.###-##")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        panel.add(documentField, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 120, 140, -1));

        addressLabel.setText("Endereço");
        panel.add(addressLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 150, -1, -1));

        addressInfo.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        addressInfo.setText("(?)");
        addressInfo.setToolTipText("Deve conter alguma informação");
        panel.add(addressInfo, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 150, -1, -1));

        mandatoryField.setForeground(new java.awt.Color(255, 0, 0));
        mandatoryField.setText("*");
        mandatoryField.setToolTipText("Campo obrigatório");
        panel.add(mandatoryField, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 150, -1, -1));
        panel.add(addressField, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 170, 140, -1));

        phoneLabel.setText("WhatsApp");
        panel.add(phoneLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 200, -1, -1));

        phoneInfo.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        phoneInfo.setText("(?)");
        phoneInfo.setToolTipText("(XX) X XXXX-XXXX");
        panel.add(phoneInfo, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 200, -1, -1));

        mandatoryField2.setForeground(new java.awt.Color(255, 0, 0));
        mandatoryField2.setText("*");
        mandatoryField2.setToolTipText("Campo obrigatório");
        panel.add(mandatoryField2, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 200, -1, -1));

        try {
            phoneField.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("+55 (##) 9 ####-####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        panel.add(phoneField, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 220, 140, -1));

        emailLabel.setText("E-Mail");
        panel.add(emailLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 50, -1, -1));

        emailInfo.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        emailInfo.setText("(?)");
        emailInfo.setToolTipText("email@site.com");
        panel.add(emailInfo, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 50, -1, -1));

        mandatoryField3.setForeground(new java.awt.Color(255, 0, 0));
        mandatoryField3.setText("*");
        mandatoryField3.setToolTipText("Campo obrigatório");
        panel.add(mandatoryField3, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 50, -1, -1));

        emailField.setToolTipText("");
        panel.add(emailField, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 70, 140, -1));

        loginLabel.setText("Login");
        panel.add(loginLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 100, -1, -1));

        loginInfo.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        loginInfo.setText("(?)");
        loginInfo.setToolTipText("example.login");
        panel.add(loginInfo, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 100, -1, -1));

        mandatoryField4.setForeground(new java.awt.Color(255, 0, 0));
        mandatoryField4.setText("*");
        mandatoryField4.setToolTipText("Campo obrigatório");
        panel.add(mandatoryField4, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 100, -1, -1));

        loginField.setToolTipText("");
        panel.add(loginField, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 120, 140, -1));

        passwordLabel.setText("Senha");
        panel.add(passwordLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 150, -1, -1));

        passwordInfo.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        passwordInfo.setText("(?)");
        passwordInfo.setToolTipText("ExamplePassword@1");
        panel.add(passwordInfo, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 150, -1, -1));

        mandatoryField5.setForeground(new java.awt.Color(255, 0, 0));
        mandatoryField5.setText("*");
        mandatoryField5.setToolTipText("Campo obrigatório");
        panel.add(mandatoryField5, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 150, -1, -1));

        passwordField.setToolTipText("");
        panel.add(passwordField, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 170, 140, -1));

        departmentLabel.setText("Departamento");
        panel.add(departmentLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 200, -1, -1));

        mandatoryField6.setForeground(new java.awt.Color(255, 0, 0));
        mandatoryField6.setText("*");
        mandatoryField6.setToolTipText("Campo obrigatório");
        panel.add(mandatoryField6, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 200, -1, -1));
        panel.add(departmentSelector, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 220, 140, -1));

        editButton.setBackground(new java.awt.Color(122, 178, 211));
        editButton.setForeground(new java.awt.Color(255, 255, 255));
        editButton.setText("Salvar");
        editButton.setToolTipText("Clique para salvar");
        editButton.setBorder(null);
        editButton.setPreferredSize(new java.awt.Dimension(50, 25));
        editButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                buttonMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                buttonMouseExited(evt);
            }
        });
        editButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editClick(evt);
            }
        });
        panel.add(editButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 270, 120, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void buttonMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_buttonMouseEntered
        // TODO add your handling code here:
        evt.getComponent().setBackground(Main.getDarkerButtonBackgroundColor());
    }//GEN-LAST:event_buttonMouseEntered

    private void buttonMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_buttonMouseExited
        // TODO add your handling code here:
        evt.getComponent().setBackground(Main.getButtonBackgroundColor());
    }//GEN-LAST:event_buttonMouseExited

    private void editClick(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editClick
        // TODO add your handling code here:
        String validationError = Util.validateFields(nameField, documentField, null, addressField, phoneField, emailField, loginField, passwordField, null);
        if(validationError != null) {
            Util.showError(this, validationError);
            return;
        }
        String name = nameField.getText(), document = documentField.getText(), address = addressField.getText(), phone = phoneField.getText(), email = emailField.getText(), login = loginField.getText(), password = passwordField.getText();
        Department department = Department.valueOf(departmentSelector.getItemAt(departmentSelector.getSelectedIndex()));
        if(department == null) {
            Util.showError(this, "Departamento não encontrado.");
            return;
        }
        manager.getAllTypes().remove(employee);
        employee.setName(name);
        employee.setDocument(document);
        employee.setAddress(address);
        employee.setPhone(phone);
        employee.setEmail(email);
        employee.setLogin(login);
        employee.setPassword(password);
        employee.setDepartment(department);
        manager.getAllTypes().add(employee);
        manager.getDatabase().save(manager.getAllTypes());
        dispose();
        AdminAppView.requestUpdateVisualization();
    }//GEN-LAST:event_editClick

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField addressField;
    private javax.swing.JLabel addressInfo;
    private javax.swing.JLabel addressLabel;
    private javax.swing.JLabel departmentLabel;
    private javax.swing.JComboBox<String> departmentSelector;
    private javax.swing.JFormattedTextField documentField;
    private javax.swing.JLabel documentInfo;
    private javax.swing.JLabel documentLabel;
    private javax.swing.JButton editButton;
    private javax.swing.JTextField emailField;
    private javax.swing.JLabel emailInfo;
    private javax.swing.JLabel emailLabel;
    private javax.swing.JTextField loginField;
    private javax.swing.JLabel loginInfo;
    private javax.swing.JLabel loginLabel;
    private javax.swing.JLabel mandatoryField;
    private javax.swing.JLabel mandatoryField1;
    private javax.swing.JLabel mandatoryField2;
    private javax.swing.JLabel mandatoryField3;
    private javax.swing.JLabel mandatoryField4;
    private javax.swing.JLabel mandatoryField5;
    private javax.swing.JLabel mandatoryField6;
    private javax.swing.JLabel mandatoryField7;
    private javax.swing.JTextField nameField;
    private javax.swing.JLabel nameInfo;
    private javax.swing.JLabel nameLabel;
    private javax.swing.JPanel panel;
    private javax.swing.JTextField passwordField;
    private javax.swing.JLabel passwordInfo;
    private javax.swing.JLabel passwordLabel;
    private javax.swing.JFormattedTextField phoneField;
    private javax.swing.JLabel phoneInfo;
    private javax.swing.JLabel phoneLabel;
    private javax.swing.JLabel title;
    // End of variables declaration//GEN-END:variables
}
