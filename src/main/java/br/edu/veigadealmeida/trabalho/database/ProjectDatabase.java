/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.edu.veigadealmeida.trabalho.database;

import br.edu.veigadealmeida.trabalho.model.Project;

/**
 *
 * @author Pedro
 */
public class ProjectDatabase extends DatabaseImpl<String, Project>{

    public ProjectDatabase() {
        super("projects", Project.class);
    }
}