/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.edu.veigadealmeida.trabalho.model;

/**
 *
 * @author Pedro
 */
public class Project extends Model {
    
    private String description, partner, responsibleEmployee;
    
    public Project(String line) {
        super(line);
    }
    
    public Project(String name, String description, String partner, String responsibleEmployee) {
        super(name);
        this.description = description;
        this.partner = partner;
        this.responsibleEmployee = responsibleEmployee;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getPartner() {
        return partner;
    }

    public void setPartner(String partner) {
        this.partner = partner;
    }

    public String getResponsibleEmployee() {
        return responsibleEmployee;
    }

    public void setResponsibleEmployee(String responsibleEmployee) {
        this.responsibleEmployee = responsibleEmployee;
    }

    @Override
    public void fill(String[] data) {
        if(data.length < 4) return;
        this.description = data[1];
        this.partner = data[2];
        this.responsibleEmployee = data[3];
    }
    
    @Override
    public String toLine() {
        return getName() + "|" + description + "|" + partner + "|" + responsibleEmployee;
    }
}
