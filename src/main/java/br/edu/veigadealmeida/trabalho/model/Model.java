/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.edu.veigadealmeida.trabalho.model;

/**
 *
 * @author Pedro
 */
public abstract class Model {
    
    public static <T extends Class<? extends Model>> Model fromLine(T t, String line) {
        try {
            return t.getDeclaredConstructor(String.class).newInstance(line);
        } catch(Exception exception) {
            exception.printStackTrace();
        }
        return null;
    }
    
    private String name;
    
    public Model(String s) {
        String[] data = s.split("\\|");
        if(data.length < 1) return;
        this.name = data[0];
        if(data.length > 1)
            fill(data);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    
    public abstract void fill(String[] data);
    
    public abstract String toLine();
}
