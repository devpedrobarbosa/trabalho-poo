/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.edu.veigadealmeida.trabalho.manager;

import br.edu.veigadealmeida.trabalho.database.CustomerDatabase;
import br.edu.veigadealmeida.trabalho.model.Customer;
import br.edu.veigadealmeida.trabalho.util.Util;
import java.util.List;

/**
 *
 * @author Pedro
 */
public class CustomerManager extends Manager<String, Customer>{
    
    public CustomerManager(CustomerDatabase database) {
        super(database);
    }
    
    public String[][] toDataArray(List<Customer> list) {
        String[][] data = new String[list.size()][Util.countClassFields(Customer.class)];
        for(int i = 0; i < list.size(); i++) {
            Customer partner = list.get(i);
            if(partner == null) continue;
            data[i][0] = partner.getName();
            data[i][1] = partner.getDocument();
            data[i][2] = partner.getAddress();
            data[i][3] = partner.getPhone();
            data[i][4] = partner.getEmail();
            data[i][5] = partner.getRepresentative();
            data[i][6] = partner.getResponsibleEmployee();
            data[i][7] = partner.getLogin();
            data[i][8] = partner.getPassword();
        }
        return data;
    }
}
