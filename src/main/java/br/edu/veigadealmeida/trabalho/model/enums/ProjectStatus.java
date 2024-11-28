/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.edu.veigadealmeida.trabalho.model.enums;

/**
 *
 * @author Pedro
 */
public enum ProjectStatus {
    
    CREATED("Criado"),
    ACTIVE("Ativo"),
    PENDING("Pendente"),
    FINISHED("Finalizado");
    
    private final String displayName;

    private ProjectStatus(String displayName) {
        this.displayName = displayName;
    }

    public String getDisplayName() {
        return displayName;
    }
}