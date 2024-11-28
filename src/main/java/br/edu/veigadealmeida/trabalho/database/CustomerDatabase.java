/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.edu.veigadealmeida.trabalho.database;

import br.edu.veigadealmeida.trabalho.model.Customer;
import br.edu.veigadealmeida.trabalho.model.Employee;

/**
 *
 * @author Pedro
 */
public class CustomerDatabase extends DatabaseImpl<String, Customer>{

    public CustomerDatabase() {
        super("customers", Customer.class);
    }
    
    public Customer findByLoginAndPassword(String login, String password) {
        return findAll().stream().filter(employee -> employee.getLogin().equals(login) && employee.getPassword().equals(password)).findFirst().orElse(null);
    }
}