/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.edu.veigadealmeida.trabalho.manager;

import br.edu.veigadealmeida.trabalho.database.TaskDatabase;
import br.edu.veigadealmeida.trabalho.model.Employee;
import br.edu.veigadealmeida.trabalho.model.Task;
import br.edu.veigadealmeida.trabalho.util.Util;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.List;

/**
 *
 * @author Pedro
 */
public class TaskManager extends Manager<String, Task> {

    private static final DateFormat writeFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
    
    public TaskManager(TaskDatabase database) {
        super(database);
    }

    @Override
    public String[][] toDataArray(List<Task> tasks) {
        String[][] data = new String[tasks.size()][Util.countClassFields(Employee.class)];
        for(int i = 0; i < tasks.size(); i++) {
            Task task = tasks.get(i);
            if(task == null)
                continue;
            data[i][0] = task.getId();
            data[i][1] = task.getName();
            data[i][2] = task.getProject();
            data[i][3] = task.getResponsibleEmployee();
            data[i][4] = task.getStart() == null ? "Não definido" : writeFormat.format(task.getStart());
            data[i][5] = task.getEndTerm() == null ? "Não definido" : writeFormat.format(task.getEndTerm());
            data[i][6] = task.getStatus().getDisplayName();
        }
        return data;
    }
    
    public String[][] toResumedDataArray(List<Task> list) {
        String[][] data = new String[list.size()][4];
        for(int i = 0; i < list.size(); i++) {
            Task task = list.get(i);
            if(task == null)
                continue;
            data[i][0] = task.getId();
            data[i][1] = task.getName();
            data[i][2] = task.getProject();
            data[i][3] = task.getStatus().getDisplayName();
        }
        return data;
    }
}
