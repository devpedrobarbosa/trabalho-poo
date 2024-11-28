/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.edu.veigadealmeida.trabalho.model;

/**
 *
 * @author Pedro
 */
public class Customer extends Model{
    
    private String document, address, phone, email, representative, responsibleEmployee, login, password;

    public Customer(String line) {
        super(line);
    }
    
    public Customer(String name, String document, String address, String phone, String email, String representative, String responsibleEmployee, String login, String password) {
        super(name);
        this.document = document;
        this.address = address;
        this.phone = phone;
        this.email = email;
        this.representative = representative;
        this.responsibleEmployee = responsibleEmployee;
        this.login = login;
        this.password = password;
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

    public String getRepresentative() {
        return representative;
    }

    public void setRepresentative(String representative) {
        this.representative = representative;
    }

    public String getResponsibleEmployee() {
        return responsibleEmployee;
    }

    public void setResponsibleEmployee(String responsibleEmployee) {
        this.responsibleEmployee = responsibleEmployee;
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

    @Override
    public void fill(String[] data) {
        if(data.length < 9) return;
        this.document = data[1];
        this.address = data[2];
        this.phone = data[3];
        this.email = data[4];
        this.representative = data[5];
        this.responsibleEmployee = data[6];
        this.login = data[7];
        this.password = data[8];
    }
    
    @Override
    public String toLine() {
        return getName() + "|" + document + "|" + address + "|" + phone + "|" + email + "|" + representative + "|" + responsibleEmployee + "|" + login + "|" + password;
    }
}