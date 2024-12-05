/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.edu.veigadealmeida.trabalho.model.enums;

import java.util.Arrays;

/**
 *
 * @author Pedro
 */
public enum Department {
    
    DEV("Desenvolvimento"),
    PMO("Gerência de Projetos"),
    ADMIN("Administração");
    
    public static Department fromDisplayName(String displayName) {
        return Arrays.stream(values()).filter(department -> department.getDisplayName().toLowerCase().contains(displayName.toLowerCase())).findFirst().orElse(null);
    }
    
    private String displayName;
    
    Department(String displayName) {
        this.displayName = displayName;
    }

    public String getDisplayName() {
        return displayName;
    }
}