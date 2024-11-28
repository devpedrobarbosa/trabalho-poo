/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.edu.veigadealmeida.trabalho.database;

import br.edu.veigadealmeida.trabalho.model.Model;
import br.edu.veigadealmeida.trabalho.model.Task;

/**
 *
 * @author Pedro
 */
public class TaskDatabase extends DatabaseImpl<String, Task> {

    public TaskDatabase() {
        super("tasks", Task.class);
    }
}
