    /*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.edu.veigadealmeida.trabalho.manager;

import br.edu.veigadealmeida.trabalho.database.EmployeeDatabase;
import br.edu.veigadealmeida.trabalho.model.Employee;
import br.edu.veigadealmeida.trabalho.util.Util;
import java.util.List;

/**
 *
 * @author Pedro
 */
public class EmployeeManager extends Manager<String, Employee> {
    
    public EmployeeManager(EmployeeDatabase database) {
        super(database);
    }
    
    public String[][] toDataArray(List<Employee> employees) {
        String[][] data = new String[employees.size()][Util.countClassFields(Employee.class)];
        for(int i = 0; i < employees.size(); i++) {
            Employee employee = employees.get(i);
            if(employee == null)
                continue;
            data[i][0] = employee.getName();
            data[i][1] = employee.getDocument();
            data[i][2] = employee.getAddress();
            data[i][3] = employee.getPhone();
            data[i][4] = employee.getEmail();
            data[i][5] = employee.getLogin();
            data[i][6] = employee.getPassword();
            data[i][7] = employee.getDepartment().getDisplayName();
        }
        return data;
    }
}