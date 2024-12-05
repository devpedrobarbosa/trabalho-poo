/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.edu.veigadealmeida.trabalho.manager;

import br.edu.veigadealmeida.trabalho.database.Database;
import br.edu.veigadealmeida.trabalho.model.Project;
import java.util.List;

/**
 *
 * @author Pedro
 */
public class ProjectManager extends Manager<String, Project> {

    public ProjectManager(Database<String, Project> database) {
        super(database);
    }

    @Override
    public String[][] toDataArray(List<Project> list) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
    public String[][] toResumedDataArray(List<Project> list) {
        String[][] data = new String[list.size()][3];
        for(int i = 0; i < list.size(); i++) {
            Project project = list.get(i);
            if(project == null)
                continue;
            data[i][0] = project.getName();
            data[i][1] = project.getCustomer();
            data[i][2] = project.getStatus().getDisplayName();
        }
        return data;
    }
}