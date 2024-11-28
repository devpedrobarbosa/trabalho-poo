/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.edu.veigadealmeida.trabalho.manager;

import br.edu.veigadealmeida.trabalho.database.Database;
import br.edu.veigadealmeida.trabalho.database.TaskDatabase;
import br.edu.veigadealmeida.trabalho.model.Employee;
import br.edu.veigadealmeida.trabalho.model.Task;
import br.edu.veigadealmeida.trabalho.util.Util;
import java.util.List;

/**
 *
 * @author Pedro
 */
public class TaskManager extends Manager<String, Task> {

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
            data[i][3] = task.getStart() == null ? "Não definido" : task.getStart().toString();
            data[i][4] = task.getEndTerm() == null ? "Não definido" : task.getEndTerm().toString();
        }
        return data;
    }
}
