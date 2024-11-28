/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.edu.veigadealmeida.trabalho.database;

import br.edu.veigadealmeida.trabalho.model.Employee;

/**
 *
 * @author Pedro
 */
public class EmployeeDatabase extends DatabaseImpl<String, Employee> {

    public EmployeeDatabase() {
        super("employees", Employee.class);
    }
    
    public Employee findByLoginAndPassword(String login, String password) {
        return findAll().stream().filter(employee -> employee.getLogin().equals(login) && employee.getPassword().equals(password)).findFirst().orElse(null);
    }
}