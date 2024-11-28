/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.edu.veigadealmeida.trabalho.model;

import br.edu.veigadealmeida.trabalho.model.enums.ProjectStatus;
import java.util.Date;

/**
 *
 * @author Pedro
 */
public class Project extends Model {
    
    private String description, customer, responsibleEmployee;
    private Date start, endTerm;
    private ProjectStatus status;
    
    public Project(String line) {
        super(line);
    }
    
    public Project(String name, String description, String partner, String responsibleEmployee, Date start, Date endTerm, ProjectStatus status) {
        super(name);
        this.description = description;
        this.customer = partner;
        this.responsibleEmployee = responsibleEmployee;
        this.start = start;
        this.endTerm = endTerm;
        this.status = status;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getPartner() {
        return customer;
    }

    public void setPartner(String partner) {
        this.customer = partner;
    }

    public String getResponsibleEmployee() {
        return responsibleEmployee;
    }

    public void setResponsibleEmployee(String responsibleEmployee) {
        this.responsibleEmployee = responsibleEmployee;
    }

    public String getCustomer() {
        return customer;
    }

    public void setCustomer(String customer) {
        this.customer = customer;
    }

    public Date getStart() {
        return start;
    }

    public void setStart(Date start) {
        this.start = start;
    }

    public Date getEndTerm() {
        return endTerm;
    }

    public void setEndTerm(Date endTerm) {
        this.endTerm = endTerm;
    }

    public ProjectStatus getStatus() {
        return status;
    }

    public void setStatus(ProjectStatus status) {
        this.status = status;
    }

    @Override
    public void fill(String[] data) {
        if(data.length < 6) return;
        this.description = data[1];
        this.customer = data[2];
        this.responsibleEmployee = data[3];
        final long startTime = Long.parseLong(data[4]), endTermTime = Long.parseLong(data[5]);
        start = startTime < 0 ? null : new Date(startTime);
        endTerm = endTermTime < 0 ? null : new Date(endTermTime);
        status = ProjectStatus.valueOf(data[6].toUpperCase());
    }
    
    @Override
    public String toLine() {
        final long startTime = start == null ? -1 : start.getTime(), endTermTime = endTerm == null ? -1 : endTerm.getTime();
        return getName() + "|" + description + "|" + customer + "|" + responsibleEmployee + "|" + startTime + "|" + endTermTime + "|" + status.name();
    }
}
