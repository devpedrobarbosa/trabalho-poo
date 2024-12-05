/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package br.edu.veigadealmeida.trabalho.view.tab;

import br.edu.veigadealmeida.trabalho.Main;
import br.edu.veigadealmeida.trabalho.database.CustomerDatabase;
import br.edu.veigadealmeida.trabalho.database.EmployeeDatabase;
import br.edu.veigadealmeida.trabalho.database.ProjectDatabase;
import br.edu.veigadealmeida.trabalho.database.TaskDatabase;
import br.edu.veigadealmeida.trabalho.manager.CustomerManager;
import br.edu.veigadealmeida.trabalho.manager.EmployeeManager;
import br.edu.veigadealmeida.trabalho.manager.ProjectManager;
import br.edu.veigadealmeida.trabalho.manager.TaskManager;
import br.edu.veigadealmeida.trabalho.model.Customer;
import br.edu.veigadealmeida.trabalho.model.Employee;
import br.edu.veigadealmeida.trabalho.model.Model;
import br.edu.veigadealmeida.trabalho.model.Project;
import br.edu.veigadealmeida.trabalho.model.enums.Department;
import br.edu.veigadealmeida.trabalho.model.enums.Status;
import br.edu.veigadealmeida.trabalho.util.Util;
import br.edu.veigadealmeida.trabalho.view.project.AddProjectView;
import br.edu.veigadealmeida.trabalho.view.project.DeleteProjectView;
import br.edu.veigadealmeida.trabalho.view.project.ProjectPanel;
import java.util.Date;
import java.util.List;
import java.util.Map;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JSeparator;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Pedro
 */
public class ProjectsTab extends javax.swing.JPanel {

    private static final ProjectDatabase projectDatabase = new ProjectDatabase();
    private static final EmployeeDatabase employeeDatabase = new EmployeeDatabase();
    private static final CustomerDatabase customerDatabase = new CustomerDatabase();
    private static final TaskDatabase taskDatabase = new TaskDatabase();
    private final Model model;
    private ProjectManager projectManager;
    private EmployeeManager employeeManager;
    private CustomerManager customerManager;
    private TaskManager taskManager;
    
    private final Map<String, Main.Func2<Project, String, Boolean>> columnFilters;
  
    
    /**
     * Creates new form ProjectsTab
     * @param model
     */
    public ProjectsTab(Model model) {
        initComponents();
        this.model = model;
        final String[] columns = new String[]{"Nome", "Descrição", "Cliente", "Funcionário Resp.", "Início", "Prazo", "Status"};
        filterSelector.setModel(new DefaultComboBoxModel<>(columns));
        columnFilters = Map.of(
                columns[0], (p, s) -> p.getName().toLowerCase().contains(s.toLowerCase()),
                columns[1], (p, s) -> p.getDescription().toLowerCase().contains(s.toLowerCase()),
                columns[2], (p, s) -> p.getCustomer().toLowerCase().contains(s.toLowerCase()),
                columns[3], (p, s) -> p.getResponsibleEmployee().toLowerCase().contains(s.toLowerCase()),
                columns[4], (p, s) -> p.getStart().toString().toLowerCase().contains(s.toLowerCase()),
                columns[5], (p, s) -> p.getEndTerm().toString().toLowerCase().contains(s.toLowerCase()),
                columns[6], (p, s) -> p.getStatus().name().toLowerCase().contains(s.toLowerCase())
        );
        if(!(model instanceof Employee) && !(model instanceof Customer)) return;
        projectManager = new ProjectManager(projectDatabase);
        employeeManager = new EmployeeManager(employeeDatabase);
        customerManager = new CustomerManager(customerDatabase);
        taskManager = new TaskManager(taskDatabase);
        updateProjects(null);
        if(model instanceof Customer || (model instanceof Employee employee && employee.getDepartment().ordinal() < Department.PMO.ordinal())) {
            addButton.setEnabled(false);
            deleteButton.setEnabled(false);
        }
    }

    private void updateProjects(List<Project> list) {
        projects.removeAll();
        if(list == null) list = projectManager.getAllTypes();
        boolean first = true;
        for(Project project : list) {
            if(project.getStatus() != Status.FINISHED && project.getEndTerm() != null && new Date().after(project.getEndTerm())) {
                projectManager.getAllTypes().removeIf(p -> p.getName().equalsIgnoreCase(project.getName()));
                project.setStatus(Status.PENDING);
                projectManager.getAllTypes().add(project);
                projectDatabase.save(projectManager.getAllTypes());
            }
            if(model instanceof Customer customer && !project.getPartner().equals(customer.getName()))
                continue;
            if(first) first = false;
            else projects.add(new JSeparator());
            projects.add(new ProjectPanel(model, project, projectManager, employeeManager, taskManager, customerManager));
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

        searchBar = new javax.swing.JPanel();
        titleLabel = new javax.swing.JLabel();
        filterSelector = new javax.swing.JComboBox<>();
        queryField = new javax.swing.JTextField();
        filterButton = new javax.swing.JButton();
        resetFilterButton = new javax.swing.JButton();
        buttonBar = new javax.swing.JPanel();
        addButton = new javax.swing.JButton();
        deleteButton = new javax.swing.JButton();
        scrollPane = new javax.swing.JScrollPane();
        projects = new javax.swing.JPanel();

        setLayout(new javax.swing.BoxLayout(this, javax.swing.BoxLayout.PAGE_AXIS));

        searchBar.setPreferredSize(new java.awt.Dimension(877, 50));

        titleLabel.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        titleLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        titleLabel.setText("Projetos");

        filterSelector.setBorder(null);
        filterSelector.setPreferredSize(new java.awt.Dimension(72, 25));

        queryField.setToolTipText("Pesquisar");
        queryField.setPreferredSize(new java.awt.Dimension(64, 25));
        queryField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                typeQuery(evt);
            }
        });

        filterButton.setText("Filtrar");
        filterButton.setToolTipText("Clique para filtrar");
        filterButton.setPreferredSize(new java.awt.Dimension(75, 25));
        filterButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                typeQuery(evt);
            }
        });

        resetFilterButton.setText("Limpar Filtro");
        resetFilterButton.setToolTipText("Clique para limpar o filtro");
        resetFilterButton.setPreferredSize(new java.awt.Dimension(125, 25));
        resetFilterButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                resetFilter(evt);
            }
        });

        javax.swing.GroupLayout searchBarLayout = new javax.swing.GroupLayout(searchBar);
        searchBar.setLayout(searchBarLayout);
        searchBarLayout.setHorizontalGroup(
            searchBarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, searchBarLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(titleLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 100, Short.MAX_VALUE)
                .addComponent(filterSelector, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(queryField, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(filterButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(resetFilterButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        searchBarLayout.setVerticalGroup(
            searchBarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(searchBarLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(searchBarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(searchBarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(filterSelector, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(queryField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(filterButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(resetFilterButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(titleLabel))
                .addContainerGap())
        );

        add(searchBar);

        buttonBar.setMaximumSize(new java.awt.Dimension(32767, 35));
        buttonBar.setMinimumSize(new java.awt.Dimension(100, 35));
        buttonBar.setPreferredSize(new java.awt.Dimension(877, 35));

        addButton.setText("Cadastrar Projeto");
        addButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addButtonActionPerformed(evt);
            }
        });

        deleteButton.setText("Remover Projeto");
        deleteButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout buttonBarLayout = new javax.swing.GroupLayout(buttonBar);
        buttonBar.setLayout(buttonBarLayout);
        buttonBarLayout.setHorizontalGroup(
            buttonBarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(buttonBarLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(addButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(deleteButton)
                .addContainerGap(626, Short.MAX_VALUE))
        );
        buttonBarLayout.setVerticalGroup(
            buttonBarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(buttonBarLayout.createSequentialGroup()
                .addGroup(buttonBarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(addButton)
                    .addComponent(deleteButton))
                .addGap(0, 12, Short.MAX_VALUE))
        );

        add(buttonBar);

        scrollPane.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);

        projects.setLayout(new javax.swing.BoxLayout(projects, javax.swing.BoxLayout.PAGE_AXIS));
        scrollPane.setViewportView(projects);

        add(scrollPane);
    }// </editor-fold>//GEN-END:initComponents

    private void typeQuery(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_typeQuery
        // TODO add your handling code here:
        filterTable();
    }//GEN-LAST:event_typeQuery

    private void resetFilter(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_resetFilter
        // TODO add your handling code here:
        queryField.setText("");
        filterTable();
    }//GEN-LAST:event_resetFilter

    private void addButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addButtonActionPerformed
        // TODO add your handling code here:
        new AddProjectView((Employee) model, projectManager, customerManager, employeeManager).setVisible(true);
    }//GEN-LAST:event_addButtonActionPerformed

    private void deleteButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteButtonActionPerformed
        // TODO add your handling code here:
        if(projectManager.getAllTypes().isEmpty()) {
            Util.showError(this, "Nenhum projeto cadastrado.");
            return;
        }
        new DeleteProjectView(projectManager).setVisible(true);
    }//GEN-LAST:event_deleteButtonActionPerformed
                     
        //Função que filtra a tabela com base no campo selcionado e no texto da barra de pesquisa
    private void filterTable() {
        Main.Func2<Project, String, Boolean> func = columnFilters.get(filterSelector.getItemAt(filterSelector.getSelectedIndex())); //Recupera a função que valida os funcionários com base no filtro em questão
        if(func == null) return; //Caso não exista uma função de filtragem definida para o campo em questão, parar aqui
        String query = queryField.getText(); //Texto que precisa estar contido (texto da barra de busca)
        List<Project> list = projectManager.getAllTypes().stream().filter(project -> func.make(project, query)).toList();
        updateProjects(list);
        revalidate(); //revalidate() serve pra atualizar a visualização para o usuário (nativo do Swing)
    } 

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addButton;
    private javax.swing.JPanel buttonBar;
    private javax.swing.JButton deleteButton;
    private javax.swing.JButton filterButton;
    private javax.swing.JComboBox<String> filterSelector;
    private javax.swing.JPanel projects;
    private javax.swing.JTextField queryField;
    private javax.swing.JButton resetFilterButton;
    private javax.swing.JScrollPane scrollPane;
    private javax.swing.JPanel searchBar;
    private javax.swing.JLabel titleLabel;
    // End of variables declaration//GEN-END:variables
}
