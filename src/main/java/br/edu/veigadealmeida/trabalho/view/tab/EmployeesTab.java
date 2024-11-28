/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package br.edu.veigadealmeida.trabalho.view.tab;

import br.edu.veigadealmeida.trabalho.Main;
import br.edu.veigadealmeida.trabalho.database.EmployeeDatabase;
import br.edu.veigadealmeida.trabalho.manager.EmployeeManager;
import br.edu.veigadealmeida.trabalho.model.Employee;
import br.edu.veigadealmeida.trabalho.model.enums.Department;
import br.edu.veigadealmeida.trabalho.util.Util;
import br.edu.veigadealmeida.trabalho.view.employee.AddEmployeeView;
import br.edu.veigadealmeida.trabalho.view.employee.DeleteEmployeeView;
import br.edu.veigadealmeida.trabalho.view.employee.EditEmployeeView;
import java.util.Enumeration;
import java.util.Map;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;

/**
 *
 * @author Pedro
 */
public class EmployeesTab extends javax.swing.JPanel {
    
    private static final EmployeeDatabase database = new EmployeeDatabase();
    
    private final EmployeeManager manager;
    
    private final String[] columns;
    
    private final Map<String, Main.Func2<Employee, String, Boolean>> columnFilters;
    
    private final Employee employee;
    
    /**
     * Creates new form EmployeesDisplay
     */
    public EmployeesTab(Employee employee) { //Iniciado exibição de funcionários
        initComponents(); //Código gerado
        manager = new EmployeeManager(database); //Instância do Manager
        columns = new String[]{"Nome", "Documento", "Endereço", "Telefone", "E-Mail", "Login", "Senha", "Departamento"}; //Definição das colunas da tabela
        table.setModel(new DefaultTableModel(manager.toDataArray(), columns)); //Definição dos dados da tabela (efetivamente, os usuários que aparecerão)
        fixColumnWidth(); //Garante que todas as colunas tenham tamanhos propícios ao texto contido nas células
        table.setDefaultEditor(Object.class, null); //Impede que o texto da tabela seja editado manualmente, prejudicando a confiabilidade dos dados
        filterSelector.setModel(new DefaultComboBoxModel<>(columns)); //Inicia o seletor de campos para o filtro por campo
        columnFilters = Map.of(
                "Nome", (e, s) -> e.getName().toLowerCase().startsWith(s.toLowerCase()),
                "Documento", (e, s) -> e.getDocument().startsWith(s),
                "Endereço", (e, s) -> e.getAddress().toLowerCase().startsWith(s.toLowerCase()),
                "Telefone", (e, s) -> e.getPhone().startsWith(s),
                "E-Mail", (e, s) -> e.getEmail().toLowerCase().startsWith(s.toLowerCase()),
                "Login", (e, s) -> e.getLogin().toLowerCase().startsWith(s.toLowerCase()),
                "Senha", (e, s) -> e.getPassword().toLowerCase().startsWith(s.toLowerCase()),
                "Departamento", (e, s) -> e.getDepartment().getDisplayName().toLowerCase().startsWith(s.toLowerCase())
        ); //Define a condição de filtragem para cada coluna da tabela recebendo um funcionário para comparação
        this.employee = employee;
        if(!employee.getDepartment().equals(Department.ADMIN)) {
            addButton.setEnabled(false);
            editButton.setEnabled(false);
            deleteButton.setEnabled(false);
        }
    }
    
    /*
    Garante que todas as colunas tenham o mesmo tamanho mínimo
    */
    private void fixColumnWidth() {
        Enumeration<TableColumn> tableColumns = table.getColumnModel().getColumns();
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

        searchBar = new javax.swing.JPanel();
        titleLabel = new javax.swing.JLabel();
        filterSelector = new javax.swing.JComboBox<>();
        queryField = new javax.swing.JTextField();
        filterButton = new javax.swing.JButton();
        resetFilterButton = new javax.swing.JButton();
        scrollPane = new javax.swing.JScrollPane();
        table = new javax.swing.JTable();
        footer = new javax.swing.JPanel();
        addButton = new javax.swing.JButton();
        deleteButton = new javax.swing.JButton();
        editButton = new javax.swing.JButton();

        setLayout(new javax.swing.BoxLayout(this, javax.swing.BoxLayout.PAGE_AXIS));

        searchBar.setPreferredSize(new java.awt.Dimension(877, 50));

        titleLabel.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        titleLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        titleLabel.setText("Funcionários");

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

        table.setModel(new javax.swing.table.DefaultTableModel(
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
        table.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_OFF);
        scrollPane.setViewportView(table);

        add(scrollPane);

        addButton.setText("Cadastrar Funcionário");
        addButton.setPreferredSize(new java.awt.Dimension(175, 23));
        addButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addEmployeeClick(evt);
            }
        });

        deleteButton.setText("Deletar Funcionário");
        deleteButton.setPreferredSize(new java.awt.Dimension(175, 23));
        deleteButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteButtonClick(evt);
            }
        });

        editButton.setText("Alterar Funcionário");
        editButton.setPreferredSize(new java.awt.Dimension(175, 23));
        editButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editButtonClick(evt);
            }
        });

        javax.swing.GroupLayout footerLayout = new javax.swing.GroupLayout(footer);
        footer.setLayout(footerLayout);
        footerLayout.setHorizontalGroup(
            footerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(footerLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(addButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(deleteButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(editButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(334, Short.MAX_VALUE))
        );
        footerLayout.setVerticalGroup(
            footerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(footerLayout.createSequentialGroup()
                .addGap(8, 8, 8)
                .addGroup(footerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(deleteButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(addButton, javax.swing.GroupLayout.DEFAULT_SIZE, 28, Short.MAX_VALUE)
                    .addComponent(editButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        add(footer);
    }// </editor-fold>//GEN-END:initComponents

    //Ao clicar em Cadastrar Funcionário, chamar tela de cadastro de funcionários
    private void addEmployeeClick(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addEmployeeClick
        // TODO add your handling code here:
        new AddEmployeeView(manager).setVisible(true);
    }//GEN-LAST:event_addEmployeeClick
    
    //Ao clicar em Remover Funcionário, chamar tela de remoção de funcionários caso haja algum cadastrado
    private void deleteButtonClick(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteButtonClick
        // TODO add your handling code here:
        if(manager.getAllTypes().isEmpty()) { //Nesse caso, nenhum cadastrado
            Util.showError(this, "Nenhum usuário cadastrado no sistema."); //Então, mostrar erro
            return; //E parar aqui
        }
        //Nesse caso, existem funcionários então mostra a tela de remoção
        new DeleteEmployeeView(manager).setVisible(true);
    }//GEN-LAST:event_deleteButtonClick

    //Ao clicar em Alterar Funcionário, chamar tela de alteração de funcionários caso haja algum selecionado da tabela
    private void editButtonClick(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editButtonClick
        // TODO add your handling code here:
        if(table.getSelectedRowCount() != 1) { //Nesse caso, nenhuma linha da tabela estava selecionada
            Util.showError(this, "Selecione 1 usuário para editar."); //Então, mostrar erro
            return; //E parar aqui
        }
        //Nesse caso, havia uma linha selecionada (equivalente a um funcionário)
        String name = table.getValueAt(table.getSelectedRow(), 0).toString(); //Recupera o nome do funcionário
        Employee employee = manager.getType(name); //Recupera o objeto do funcionário do armazenamento com base no nome
        if(employee == null) { //Por algum motivo, funcionário não encontrado. Pode ter sido removido de forma assíncrona
            Util.showError(this, "Não foi possível editar o usuário."); //Então, mostrar erro
            return; //E parar aqui
        }
        //Nesse caso, o usuário é valido, então prosseguir com a tela de alteração
        new EditEmployeeView(manager, employee).setVisible(true); //A tela de alteração recebe o funcionário selecionado para que venha preenchida com seus dados
    }//GEN-LAST:event_editButtonClick

    //Função que filtra a tabela com base no campo selcionado e no texto da barra de pesquisa
    private void filterTable() {
        Main.Func2<Employee, String, Boolean> func = columnFilters.get(filterSelector.getItemAt(filterSelector.getSelectedIndex())); //Recupera a função que valida os funcionários com base no filtro em questão
        if(func == null) return; //Caso não exista uma função de filtragem definida para o campo em questão, parar aqui
        String query = queryField.getText(); //Texto que precisa estar contido (texto da barra de busca)
        table.setModel(new DefaultTableModel(manager.toDataArray(manager.getAllTypes().stream().filter(employee -> func.make(employee, query)).toList()), columns)); //Redefine os dados da tabela após filtrar a lista de usuários
        fixColumnWidth(); //Novamente, conserta a largura das colunas
        revalidate(); //revalidate() serve pra atualizar a visualização para o usuário (nativo do Swing)
    }
    
    private void typeQuery(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_typeQuery
        // TODO add your handling code here:
        filterTable(); //Executa a função de filtrar sempre que um texto for inserido e confirmado na barra de busca
    }//GEN-LAST:event_typeQuery

    //Limpa o filtro, e filtra a tabela novamente. Como o filtro é vazio, retorna todos os elementos
    private void resetFilter(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_resetFilter
        // TODO add your handling code here:
        queryField.setText("");
        filterTable();
    }//GEN-LAST:event_resetFilter


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addButton;
    private javax.swing.JButton deleteButton;
    private javax.swing.JButton editButton;
    private javax.swing.JButton filterButton;
    private javax.swing.JComboBox<String> filterSelector;
    private javax.swing.JPanel footer;
    private javax.swing.JTextField queryField;
    private javax.swing.JButton resetFilterButton;
    private javax.swing.JScrollPane scrollPane;
    private javax.swing.JPanel searchBar;
    private javax.swing.JTable table;
    private javax.swing.JLabel titleLabel;
    // End of variables declaration//GEN-END:variables
}
