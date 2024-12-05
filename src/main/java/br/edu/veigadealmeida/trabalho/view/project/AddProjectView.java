/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package br.edu.veigadealmeida.trabalho.view.project;

import br.edu.veigadealmeida.trabalho.Main;
import br.edu.veigadealmeida.trabalho.database.ProjectDatabase;
import br.edu.veigadealmeida.trabalho.manager.EmployeeManager;
import br.edu.veigadealmeida.trabalho.manager.CustomerManager;
import br.edu.veigadealmeida.trabalho.manager.ProjectManager;
import br.edu.veigadealmeida.trabalho.model.Employee;
import br.edu.veigadealmeida.trabalho.model.Customer;
import br.edu.veigadealmeida.trabalho.model.Project;
import br.edu.veigadealmeida.trabalho.model.enums.Department;
import br.edu.veigadealmeida.trabalho.model.enums.Status;
import br.edu.veigadealmeida.trabalho.util.Util;
import br.edu.veigadealmeida.trabalho.view.AdminAppView;
import br.edu.veigadealmeida.trabalho.view.PMPAppView;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.DefaultComboBoxModel;

/**
 *
 * @author Pedro
 */
public class AddProjectView extends javax.swing.JFrame {
    
    private final Employee employee;
    private final ProjectManager projectManager;
    private final CustomerManager customerManager;
    private final EmployeeManager employeeManager;
    
    /**
     * Creates new form AddEmployeeView
     * @param partnerManager
     * @param employeeManager
     */
    public AddProjectView(Employee employee, ProjectManager projectManager, CustomerManager customerManager, EmployeeManager employeeManager) {
        initComponents();
        setLocationRelativeTo(null);
        this.employee = employee;
        this.projectManager = projectManager;
        this.customerManager = customerManager;
        this.employeeManager = employeeManager;
        responsibleEmployeeSelector.setModel(new DefaultComboBoxModel<>(employeeManager.getAllTypes().stream().filter(e -> e.getDepartment().equals(Department.PMO)).map(Employee::getName).toList().toArray(new String[0])));
        customerSelector.setModel(new DefaultComboBoxModel<>(customerManager.getAllTypes().stream().map(Customer::getName).toList().toArray(new String[0])));
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
        titleLabel = new javax.swing.JLabel();
        nameLabel = new javax.swing.JLabel();
        nameInfo = new javax.swing.JLabel();
        mandatoryField1 = new javax.swing.JLabel();
        nameField = new javax.swing.JTextField();
        responsibleEmployeeLabel = new javax.swing.JLabel();
        mandatoryField6 = new javax.swing.JLabel();
        responsibleEmployeeSelector = new javax.swing.JComboBox<>();
        addButton = new javax.swing.JButton();
        customerSelector = new javax.swing.JComboBox<>();
        responsibleEmployeeLabel1 = new javax.swing.JLabel();
        mandatoryField7 = new javax.swing.JLabel();
        endTermField = new javax.swing.JFormattedTextField();
        jLabel1 = new javax.swing.JLabel();
        mandatoryField8 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setResizable(false);

        panel.setMinimumSize(new java.awt.Dimension(300, 325));
        panel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        titleLabel.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        titleLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        titleLabel.setText("Cadastrar Projeto");
        panel.add(titleLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 10, 300, -1));

        nameLabel.setText("Nome");
        panel.add(nameLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 50, -1, -1));

        nameInfo.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        nameInfo.setText("(?)");
        nameInfo.setToolTipText("Primeira letra maiúscula, pode conter somente letras, ' e -");
        panel.add(nameInfo, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 50, -1, -1));

        mandatoryField1.setForeground(new java.awt.Color(255, 0, 0));
        mandatoryField1.setText("*");
        mandatoryField1.setToolTipText("Campo obrigatório");
        panel.add(mandatoryField1, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 50, -1, -1));

        nameField.setToolTipText("");
        panel.add(nameField, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 70, 140, -1));

        responsibleEmployeeLabel.setText("Responsável");
        panel.add(responsibleEmployeeLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 150, -1, -1));

        mandatoryField6.setForeground(new java.awt.Color(255, 0, 0));
        mandatoryField6.setText("*");
        mandatoryField6.setToolTipText("Campo obrigatório");
        panel.add(mandatoryField6, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 200, -1, -1));

        responsibleEmployeeSelector.setBorder(null);
        responsibleEmployeeSelector.setPreferredSize(new java.awt.Dimension(72, 22));
        panel.add(responsibleEmployeeSelector, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 170, 140, -1));

        addButton.setBackground(new java.awt.Color(122, 178, 211));
        addButton.setForeground(new java.awt.Color(255, 255, 255));
        addButton.setText("Cadastrar");
        addButton.setBorder(null);
        addButton.setPreferredSize(new java.awt.Dimension(50, 25));
        addButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                buttonMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                buttonMouseExited(evt);
            }
        });
        addButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addClick(evt);
            }
        });
        panel.add(addButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 270, 120, -1));

        customerSelector.setBorder(null);
        customerSelector.setPreferredSize(new java.awt.Dimension(72, 22));
        panel.add(customerSelector, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 120, 140, -1));

        responsibleEmployeeLabel1.setText("Cliente");
        panel.add(responsibleEmployeeLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 100, -1, -1));

        mandatoryField7.setForeground(new java.awt.Color(255, 0, 0));
        mandatoryField7.setText("*");
        mandatoryField7.setToolTipText("Campo obrigatório");
        panel.add(mandatoryField7, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 100, -1, -1));

        try {
            endTermField.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##/##/####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        panel.add(endTermField, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 220, 140, -1));

        jLabel1.setText("Prazo");
        panel.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 200, -1, -1));

        mandatoryField8.setForeground(new java.awt.Color(255, 0, 0));
        mandatoryField8.setText("*");
        mandatoryField8.setToolTipText("Campo obrigatório");
        panel.add(mandatoryField8, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 150, -1, -1));

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

    private void addClick(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addClick
        // TODO add your handling code here:
        String validationError = Util.validateFields(nameField, null, null, null, null, null, null, null, null);
        if(validationError != null) {
            Util.showError(this, validationError);
            return;
        }
        String name = nameField.getText();
        Customer customer = customerManager.getType(customerSelector.getItemAt(customerSelector.getSelectedIndex()));
        if(customer == null) {
            Util.showError(this, "Cliente não encontrado.");
            return;
        }
        Employee employee = employeeManager.getType(responsibleEmployeeSelector.getItemAt(responsibleEmployeeSelector.getSelectedIndex())); //Recupara o funcionário responsável pelo parceiro
        if(employee == null) { //Se não houver, mostra erro e retorna, pois é necessário um funcionário responsável pelo associado
            Util.showError(this, "Funcionário não encontrado.");
            return;
        }
        try {
            final Date date = endTermField.getText().isEmpty() ? null : new SimpleDateFormat("dd/MM/yyyy").parse(endTermField.getText());
            final Project p = new Project(name, "", customer.getName(), employee.getName(), new Date(), date, Status.CREATED);
            projectManager.getAllTypes().add(p);
            projectManager.getDatabase().save(projectManager.getAllTypes());
            dispose();
            if(this.employee.getDepartment().equals(Department.DEV))
                AdminAppView.requestUpdateVisualization();
            else PMPAppView.requestDispose();
        } catch(Exception e) {
            e.printStackTrace();
        }
        //Nesse caso, havia funcionário
        dispose();
        AdminAppView.requestUpdateVisualization();
    }//GEN-LAST:event_addClick

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addButton;
    private javax.swing.JComboBox<String> customerSelector;
    private javax.swing.JFormattedTextField endTermField;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel mandatoryField1;
    private javax.swing.JLabel mandatoryField6;
    private javax.swing.JLabel mandatoryField7;
    private javax.swing.JLabel mandatoryField8;
    private javax.swing.JTextField nameField;
    private javax.swing.JLabel nameInfo;
    private javax.swing.JLabel nameLabel;
    private javax.swing.JPanel panel;
    private javax.swing.JLabel responsibleEmployeeLabel;
    private javax.swing.JLabel responsibleEmployeeLabel1;
    private javax.swing.JComboBox<String> responsibleEmployeeSelector;
    private javax.swing.JLabel titleLabel;
    // End of variables declaration//GEN-END:variables
}
