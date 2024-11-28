/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.edu.veigadealmeida.trabalho.manager;

import br.edu.veigadealmeida.trabalho.database.Database;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Pedro
 */
public abstract class Manager<ID, Type> {
    
    private final Database<ID, Type> database;
    private final List<Type> allTypes;
    
    public Manager(Database<ID, Type> database) {
        this.database = database;
        allTypes = new ArrayList<>(database.findAll());
    }

    public Database<?, Type> getDatabase() {
        return database;
    }

    public List<Type> getAllTypes() {
        return allTypes;
    }
    
    public Type getType(ID id) {
        return database.find(id);
    }
    
    public abstract String[][] toDataArray(List<Type> list);
    
    public String[][] toDataArray() {
        return toDataArray(allTypes);
    }
}