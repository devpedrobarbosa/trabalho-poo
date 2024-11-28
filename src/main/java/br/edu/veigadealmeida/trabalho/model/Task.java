/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.edu.veigadealmeida.trabalho.model;

import br.edu.veigadealmeida.trabalho.util.Util;
import java.util.Date;

/**
 *
 * @author Pedro
 */
public class Task extends Model {
    
    private String id, project, responsibleEmployee;
    private Date start, endTerm;

    public Task(String line) {
        super(line);
    }
    
    public Task(String name, String project, String responsibleEmployee, Date start, Date endTerm) {
        super(name);
        this.id = Util.generateId();
        this.project = project;
        this.responsibleEmployee = responsibleEmployee;
        this.start = start;
        this.endTerm = endTerm;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
    
    public String getProject() {
        return project;
    }

    public void setProject(String project) {
        this.project = project;
    }

    public String getResponsibleEmployee() {
        return responsibleEmployee;
    }

    public void setResponsibleEmployee(String responsibleEmployee) {
        this.responsibleEmployee = responsibleEmployee;
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

    @Override
    public void fill(String[] data) {
        if(data.length != 6) return;
        id = data[0];
        setName(data[1]);
        project = data[2];
        responsibleEmployee = data[3];
        final long startTime = Long.parseLong(data[4]), endTermTime = Long.parseLong(data[5]);
        start = startTime < 0 ? null : new Date(startTime);
        endTerm = endTermTime < 0 ? null : new Date(endTermTime);
    }

    @Override
    public String toLine() {
        final long startTime = start == null ? -1 : start.getTime(), endTermTime = endTerm == null ? -1 : endTerm.getTime();
        return id + "|" + getName() + "|" + project + "|" + responsibleEmployee + "|" + startTime + "|" + endTermTime;
    }
}