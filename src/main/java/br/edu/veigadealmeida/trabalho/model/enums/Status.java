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
public enum Status {
    
    CREATED("Criado"),
    ACTIVE("Ativo"),
    PENDING("Pendente"),
    FINISHED("Finalizado");
    
    public static Status getByDisplayName(String displayName) {
        return Arrays.stream(values()).filter(status -> status.getDisplayName().equalsIgnoreCase(displayName)).findFirst().orElse(null);
    }
    
    private final String displayName;

    private Status(String displayName) {
        this.displayName = displayName;
    }

    public String getDisplayName() {
        return displayName;
    }
}