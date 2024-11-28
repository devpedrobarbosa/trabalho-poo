/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.edu.veigadealmeida.trabalho.model;

import br.edu.veigadealmeida.trabalho.model.enums.Department;

/**
 *
 * @author Pedro
 */
public class Employee extends Model {
    
    private String document, address, phone, email, login, password;
    private Department department;

    public Employee(String line) {
        super(line);
    }
    
    public Employee(String name, String document, String address, String phone, String email, String login, String password, Department department) {
        super(name);
        this.document = document;
        this.address = address;
        this.phone = phone;
        this.email = email;
        this.login = login;
        this.password = password;
        this.department = department;
    }

    public String getDocument() {
        return document;
    }

    public void setDocument(String document) {
        this.document = document;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    @Override
    public void fill(String[] data) {
        if(data.length < 7) return;
        this.document = data[1];
        this.address = data[2];
        this.phone = data[3];
        this.email = data[4];
        this.login = data[5];
        this.password = data[6];
        this.department = Department.valueOf(data[7].toUpperCase());
    }
    
    @Override
    public String toLine() {
        return getName() + "|" + document + "|" + address + "|" + phone + "|" + email + "|" + login + "|" + password + "|" + department.name();
    }

    @Override
    public boolean equals(Object obj) {
        if(!(obj instanceof Employee e)) return false;
        return (getName() == null ? e.getName() == null : getName().equals(e.getName())) &&
                (document == null ? e.document == null : document.equals(e.document)) &&
                (address == null ? e.address == null : address.equals(e.address)) &&
                (phone == null ? e.phone == null : phone.equals(e.phone)) && 
                (email == null ? e.email == null : email.equals(e.email)) &&
                department == e.department;
    }
}