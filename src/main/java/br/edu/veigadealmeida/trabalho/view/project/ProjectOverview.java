/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package br.edu.veigadealmeida.trabalho.view.project;

import br.edu.veigadealmeida.trabalho.manager.CustomerManager;
import br.edu.veigadealmeida.trabalho.manager.EmployeeManager;
import br.edu.veigadealmeida.trabalho.manager.ProjectManager;
import br.edu.veigadealmeida.trabalho.manager.TaskManager;
import br.edu.veigadealmeida.trabalho.model.Employee;
import br.edu.veigadealmeida.trabalho.model.Project;
import br.edu.veigadealmeida.trabalho.model.Task;
import br.edu.veigadealmeida.trabalho.model.enums.Department;
import br.edu.veigadealmeida.trabalho.model.enums.Status;
import br.edu.veigadealmeida.trabalho.util.Util;
import br.edu.veigadealmeida.trabalho.view.AdminAppView;
import br.edu.veigadealmeida.trabalho.view.PMPAppView;
import br.edu.veigadealmeida.trabalho.view.task.AddTaskView;
import br.edu.veigadealmeida.trabalho.view.task.DeleteTaskView;
import br.edu.veigadealmeida.trabalho.view.task.EditTaskView;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Enumeration;
import java.util.stream.Stream;
import javax.swing.DefaultComboBoxModel;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;

/**
 *
 * @author Pedro
 */
public class ProjectOverview extends javax.swing.JFrame {

    private static final DateFormat parserFormat = new SimpleDateFormat("dd/MM/yyyy"), writerFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
    
    private final Employee employee;
    private final Project project;
    private final ProjectManager projectManager;
    private final EmployeeManager employeeManager;
    private final CustomerManager customerManager;
    private final TaskManager taskManager;
    private final String[] columns = new String[]{"ID", "Nome", "Projeto", "Responsável", "Início", "Prazo", "Status"};
    
    /**
     * Creates new form ProjectOverview
     * @param employee
     * @param project
     * @param projectManager
     * @param employeeManager
     * @param taskManager
     * @param customerManager
     */
    public ProjectOverview(Employee employee, Project project, ProjectManager projectManager, EmployeeManager employeeManager, TaskManager taskManager, CustomerManager customerManager) {
        initComponents();
        setResizable(false);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        this.employee = employee;
        this.project = project;
        this.projectManager = projectManager;
        this.employeeManager = employeeManager;
        this.customerManager = customerManager;
        this.taskManager = taskManager;
        title.setText("Projeto #" + project.getName());
        customerField.setText(project.getPartner());
        responsibleEmployeeSelector.setModel(new DefaultComboBoxModel<>(employeeManager.getAllTypes().stream().filter(e -> e.getDepartment().equals(Department.PMO)).map(Employee::getName).toList().toArray(new String[0])));
        responsibleEmployeeSelector.setSelectedItem(project.getResponsibleEmployee());
        descriptionField.setText(project.getDescription());
        statusField.setModel(new DefaultComboBoxModel<>(Stream.of(project.getStatus()).map(Status::name).toList().toArray(new String[0])));
        if(project.getStart() != null)
            startField.setText(writerFormat.format(project.getStart()));
        if(project.getEndTerm() != null)
            endTermField.setText(writerFormat.format(project.getEndTerm()));
        if(employee.getDepartment().ordinal() < Department.PMO.ordinal()) {
            customerField.setEnabled(false);
            responsibleEmployeeSelector.setEnabled(false);
            descriptionField.setEnabled(false);
            saveButton.setEnabled(false);
            finishButton.setEnabled(false);
            startField.setEnabled(false);
            endTermField.setEnabled(false);
            
            addTaskButton.setEnabled(false);
            editTaskButton.setEnabled(false);
            deleteTaskButton.setEnabled(false);
        }
        if(project.getStart() != null)
            startButton.setEnabled(false);
        if(project.getStatus().equals(Status.CREATED) || project.getStatus().equals(Status.FINISHED))
            finishButton.setEnabled(false);
        if(project.getStatus().equals(Status.FINISHED)) {
            addTaskButton.setEnabled(false);
            editTaskButton.setEnabled(false);
            deleteTaskButton.setEnabled(false);
        }
        tasksTable.setModel(new DefaultTableModel(taskManager.toDataArray(taskManager.getAllTypes().stream().filter(t -> t.getProject().equalsIgnoreCase(project.getName())).toList()), columns)); //Definição dos dados da tabela (efetivamente, os usuários que aparecerão)
        fixColumnWidth(); //Garante que todas as colunas tenham tamanhos propícios ao texto contido nas células
        tasksTable.setDefaultEditor(Object.class, null);
    }
    
    private void fixColumnWidth() {
        Enumeration<TableColumn> tableColumns = tasksTable.getColumnModel().getColumns();
        while(tableColumns.hasMoreElements()) //Para cada coluna
            tableColumns.nextElement().setMinWidth(150); //Define largura de 150
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        customerLabel = new javax.swing.JLabel();
        customerField = new javax.swing.JTextField();
        responsibleEmployeeLabel = new javax.swing.JLabel();
        responsibleEmployeeSelector = new javax.swing.JComboBox<>();
        descriptionLabel = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        descriptionField = new javax.swing.JTextArea();
        statusLabel = new javax.swing.JLabel();
        statusField = new javax.swing.JComboBox<>();
        startLabel = new javax.swing.JLabel();
        startField = new javax.swing.JFormattedTextField();
        endTermField = new javax.swing.JFormattedTextField();
        endTermLabel = new javax.swing.JLabel();
        title = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        scrollPane = new javax.swing.JScrollPane();
        tasksTable = new javax.swing.JTable();
        jPanel2 = new javax.swing.JPanel();
        saveButton = new javax.swing.JButton();
        finishButton = new javax.swing.JButton();
        startButton = new javax.swing.JButton();
        deleteTaskButton = new javax.swing.JButton();
        editTaskButton = new javax.swing.JButton();
        addTaskButton = new javax.swing.JButton();
        finishTaskButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new javax.swing.BoxLayout(getContentPane(), javax.swing.BoxLayout.PAGE_AXIS));

        customerLabel.setText("Cliente");

        customerField.setText("Client name");
        customerField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                customerFieldActionPerformed(evt);
            }
        });

        responsibleEmployeeLabel.setText("Funcionário Alocado");

        descriptionLabel.setText("Descrição");

        descriptionField.setColumns(20);
        descriptionField.setRows(5);
        jScrollPane1.setViewportView(descriptionField);

        statusLabel.setText("Status");

        statusField.setEnabled(false);

        startLabel.setText("Início");

        try {
            startField.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##/##/####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }

        try {
            endTermField.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##/##/####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }

        endTermLabel.setText("Prazo");

        title.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        title.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        title.setText("Projeto #");

        jLabel1.setText("Tarefas");

        scrollPane.setPreferredSize(new java.awt.Dimension(500, 200));

        tasksTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        tasksTable.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_OFF);
        scrollPane.setViewportView(tasksTable);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(customerField, javax.swing.GroupLayout.DEFAULT_SIZE, 135, Short.MAX_VALUE)
                                .addComponent(responsibleEmployeeLabel)
                                .addComponent(responsibleEmployeeSelector, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(customerLabel))
                            .addComponent(descriptionLabel)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 183, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(35, 35, 35)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(endTermField, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(startField)
                            .addComponent(statusField, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(startLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(endTermLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(statusLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(109, 109, 109)))
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(46, 46, 46)
                                .addComponent(jLabel1)
                                .addGap(468, 468, 468))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(scrollPane, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap())))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(title, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(24, 24, 24))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(title)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(customerLabel)
                    .addComponent(statusLabel)
                    .addComponent(jLabel1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(customerField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(statusField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(responsibleEmployeeLabel)
                            .addComponent(startLabel))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(responsibleEmployeeSelector, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(startField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(descriptionLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(endTermLabel)
                        .addGap(90, 90, 90)
                        .addComponent(endTermField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(scrollPane, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(15, Short.MAX_VALUE))
        );

        getContentPane().add(jPanel1);

        jPanel2.setMaximumSize(new java.awt.Dimension(32767, 50));
        jPanel2.setMinimumSize(new java.awt.Dimension(100, 50));
        jPanel2.setPreferredSize(new java.awt.Dimension(400, 50));

        saveButton.setText("Salvar Projeto");
        saveButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saveButtonActionPerformed(evt);
            }
        });

        finishButton.setText("Concluir Projeto");
        finishButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                finishButtonActionPerformed(evt);
            }
        });

        startButton.setText("Iniciar Projeto");
        startButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                startButtonActionPerformed(evt);
            }
        });

        deleteTaskButton.setText("Apagar Tarefa");
        deleteTaskButton.setActionCommand("Apagar Tarefa");
        deleteTaskButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteTaskButtonActionPerformed(evt);
            }
        });

        editTaskButton.setText("Alterar Tarefa");
        editTaskButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editTaskButtonActionPerformed(evt);
            }
        });

        addTaskButton.setText("Cadastrar Tarefa");
        addTaskButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addTaskButtonActionPerformed(evt);
            }
        });

        finishTaskButton.setText("Concluir Tarefa");
        finishTaskButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                finishTaskButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(saveButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(startButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(finishButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 125, Short.MAX_VALUE)
                .addComponent(addTaskButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(editTaskButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(deleteTaskButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(finishTaskButton)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(saveButton)
                    .addComponent(finishButton)
                    .addComponent(startButton)
                    .addComponent(deleteTaskButton)
                    .addComponent(editTaskButton)
                    .addComponent(addTaskButton)
                    .addComponent(finishTaskButton))
                .addContainerGap(21, Short.MAX_VALUE))
        );

        getContentPane().add(jPanel2);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void customerFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_customerFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_customerFieldActionPerformed

    private void saveButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveButtonActionPerformed
        // TODO add your handling code here:
        String validationError = Util.validateFields(customerField, null, null, null, null, null, null, null, null);
        if(validationError != null) {
            Util.showError(this, validationError);
            return;
        }
        Employee employee = employeeManager.getType(responsibleEmployeeSelector.getItemAt(responsibleEmployeeSelector.getSelectedIndex())); //Recupara o funcionário responsável pelo parceiro
        if(employee == null) { //Se não houver, mostra erro e retorna, pois é necessário um funcionário responsável pelo associado
            Util.showError(this, "Funcionário não encontrado.");
            return;
        }
        String name = customerField.getText(), responsibleEmployee = responsibleEmployeeSelector.getItemAt(responsibleEmployeeSelector.getSelectedIndex()), description = descriptionField.getText();
        projectManager.getAllTypes().removeIf(p -> p.getName().equalsIgnoreCase(project.getName()));
        project.setName(name);
        project.setResponsibleEmployee(responsibleEmployee);
        project.setDescription(description);
        Date start = null, endTerm = null;
        if(!startField.getText().isEmpty()) {
            try {
                start = parserFormat.parse(startField.getText());
            } catch(Exception e) {
                e.printStackTrace();
                start = null;
            }
        }
        if(!endTermField.getText().isEmpty()) {
            try {
                endTerm = parserFormat.parse(endTermField.getText());
            } catch(Exception e) {
                e.printStackTrace();
                endTerm = null;
            }
        }
        project.setStart(start);
        project.setEndTerm(endTerm);
        projectManager.getAllTypes().add(project);
        projectManager.getDatabase().save(projectManager.getAllTypes());
        dispose();
        if(this.employee.getDepartment().equals(Department.ADMIN))
            AdminAppView.requestUpdateVisualization();
        else PMPAppView.requestUpdateVisualization();
    }//GEN-LAST:event_saveButtonActionPerformed

    private void startButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_startButtonActionPerformed
        // TODO add your handling code here:
        projectManager.getAllTypes().removeIf(p -> p.getName().equalsIgnoreCase(project.getName()));
        project.setStart(new Date());
        project.setStatus(Status.ACTIVE);
        projectManager.getAllTypes().add(project);
        projectManager.getDatabase().save(projectManager.getAllTypes());
        dispose();
        if(employee.getDepartment().equals(Department.ADMIN))
            AdminAppView.requestUpdateVisualization();
        else PMPAppView.requestUpdateVisualization();
    }//GEN-LAST:event_startButtonActionPerformed

    private void finishButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_finishButtonActionPerformed
        // TODO add your handling code here:
        projectManager.getAllTypes().removeIf(p -> p.getName().equalsIgnoreCase(project.getName()));
        project.setStatus(Status.FINISHED);
        projectManager.getAllTypes().add(project);
        projectManager.getDatabase().save(projectManager.getAllTypes());
        dispose();
        if(employee.getDepartment().equals(Department.ADMIN))
            AdminAppView.requestUpdateVisualization();
        else PMPAppView.requestUpdateVisualization();
    }//GEN-LAST:event_finishButtonActionPerformed

    private void addTaskButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addTaskButtonActionPerformed
        // TODO add your handling code here:
        new AddTaskView(employee, this, projectManager, customerManager, employeeManager, taskManager).setVisible(true);
    }//GEN-LAST:event_addTaskButtonActionPerformed

    private void editTaskButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editTaskButtonActionPerformed
        // TODO add your handling code here:
        if(tasksTable.getSelectedRowCount() < 1) {
            Util.showError(this, "Selecione 1 task para alterar");
            return;
        }
        final String taskName = tasksTable.getValueAt(tasksTable.getSelectedRow(), 1).toString();
        final Task task = taskManager.getType(taskName);
        if(task == null) {
            System.out.println(taskName);
            Util.showError(this, "Task não encontrada.");
            return;
        }
        new EditTaskView(employee, task, this, projectManager, customerManager, employeeManager, taskManager).setVisible(true);
    }//GEN-LAST:event_editTaskButtonActionPerformed

    private void deleteTaskButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteTaskButtonActionPerformed
        // TODO add your handling code here:
        new DeleteTaskView(taskManager).setVisible(true);
    }//GEN-LAST:event_deleteTaskButtonActionPerformed

    private void finishTaskButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_finishTaskButtonActionPerformed
        // TODO add your handling code here:
        if(tasksTable.getSelectedRowCount() < 1) {
            Util.showError(this, "Selecione 1 task para finalizar");
            return;
        }
        final String taskName = tasksTable.getValueAt(tasksTable.getSelectedRow(), 1).toString();
        final Task task = taskManager.getType(taskName);
        if(task == null) {
            System.out.println(taskName);
            Util.showError(this, "Task não encontrada.");
            return;
        }
        taskManager.getAllTypes().removeIf(t -> t.getId().equalsIgnoreCase(task.getId()));
        task.setStatus(Status.FINISHED);
        taskManager.getAllTypes().add(task);
        taskManager.getDatabase().save(taskManager.getAllTypes());
        update();
    }//GEN-LAST:event_finishTaskButtonActionPerformed


    public void update() {
        tasksTable.setModel(new DefaultTableModel(taskManager.toDataArray(taskManager.getAllTypes().stream().filter(t -> t.getProject().equalsIgnoreCase(project.getName())).toList()), columns)); //Definição dos dados da tabela (efetivamente, os usuários que aparecerão)
        fixColumnWidth();
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addTaskButton;
    private javax.swing.JTextField customerField;
    private javax.swing.JLabel customerLabel;
    private javax.swing.JButton deleteTaskButton;
    private javax.swing.JTextArea descriptionField;
    private javax.swing.JLabel descriptionLabel;
    private javax.swing.JButton editTaskButton;
    private javax.swing.JFormattedTextField endTermField;
    private javax.swing.JLabel endTermLabel;
    private javax.swing.JButton finishButton;
    private javax.swing.JButton finishTaskButton;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel responsibleEmployeeLabel;
    private javax.swing.JComboBox<String> responsibleEmployeeSelector;
    private javax.swing.JButton saveButton;
    private javax.swing.JScrollPane scrollPane;
    private javax.swing.JButton startButton;
    private javax.swing.JFormattedTextField startField;
    private javax.swing.JLabel startLabel;
    private javax.swing.JComboBox<String> statusField;
    private javax.swing.JLabel statusLabel;
    private javax.swing.JTable tasksTable;
    private javax.swing.JLabel title;
    // End of variables declaration//GEN-END:variables
}
