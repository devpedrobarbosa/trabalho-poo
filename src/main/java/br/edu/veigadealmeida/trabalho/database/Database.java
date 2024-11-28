/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package br.edu.veigadealmeida.trabalho.database;

import java.util.List;

/**
 *
 * @author Pedro
 */
public interface Database<ID, Type> {
    
    List<Type> findAll();
    
    Type find(ID id);
    
    void save(List<Type> types);
}
